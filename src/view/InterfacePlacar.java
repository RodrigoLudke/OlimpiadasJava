package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Equipe;
import model.Placar;

public class InterfacePlacar extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel erroLabel = new JLabel(""); // Exibir mensagens de erro

    public InterfacePlacar() {}

    private void setPanel(String title, int width, int height) {
        // Configurações da Janela
        this.setTitle(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null); // Centraliza na tela
        this.setVisible(true);
    }

    private void setPanel(String title) {
        setPanel(title, 500, 400);
    }

    // Método para criar um novo placar
    public void criarPlacar() {
        setPanel("Cadastro de Placar");

        JLabel lEquipe1 = new JLabel("ID da Equipe 1:");
        JTextField iEquipe1 = new JTextField(20);
        JLabel lEquipe2 = new JLabel("ID da Equipe 2:");
        JTextField iEquipe2 = new JTextField(20);
        JLabel lPlacarEquipe1 = new JLabel("Placar da Equipe 1:");
        JTextField iPlacarEquipe1 = new JTextField(20);
        JLabel lPlacarEquipe2 = new JLabel("Placar da Equipe 2:");
        JTextField iPlacarEquipe2 = new JTextField(20);
        JButton botao = new JButton("Cadastrar");

        // Configuração do layout com GridBagLayout
        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy = 0;
        c.add(lEquipe1, gbc);
        c.add(iEquipe1, gbc);

        gbc.gridy = 1;
        c.add(lEquipe2, gbc);
        c.add(iEquipe2, gbc);

        gbc.gridy = 2;
        c.add(lPlacarEquipe1, gbc);
        c.add(iPlacarEquipe1, gbc);

        gbc.gridy = 3;
        c.add(lPlacarEquipe2, gbc);
        c.add(iPlacarEquipe2, gbc);

        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        c.add(botao, gbc);

        // Label para Erros
        gbc.gridy = 5;
        erroLabel.setForeground(Color.RED); // Texto em vermelho
        c.add(erroLabel, gbc);

        // Ação do botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    erroLabel.setText(""); // Limpa a mensagem de erro antes de cada tentativa

                    // Obtém e valida os dados da interface
                    int idEquipe1 = Integer.parseInt(iEquipe1.getText());
                    int idEquipe2 = Integer.parseInt(iEquipe2.getText());
                    int placarEquipe1 = Integer.parseInt(iPlacarEquipe1.getText());
                    int placarEquipe2 = Integer.parseInt(iPlacarEquipe2.getText());

                    Equipe equipe1 = Equipe.buscaEquipe(idEquipe1);
                    Equipe equipe2 = Equipe.buscaEquipe(idEquipe2);

                    if (equipe1 == null || equipe2 == null) {
                        throw new Exception("Uma ou ambas as equipes não foram encontradas.");
                    }

                    Placar placar = new Placar(equipe1, equipe2, placarEquipe1, placarEquipe2);
                    placar.inserir();

                    JOptionPane.showMessageDialog(null, "Placar cadastrado com sucesso!");
                    dispose();
                } catch (NumberFormatException nfe) {
                    erroLabel.setText("IDs e placares devem ser valores numéricos.");
                } catch (Exception ex) {
                    erroLabel.setText(ex.getMessage());
                }
            }
        });
    }

    // Método para exibir um placar por equipes
    public void exibirPlacarPorEquipe() {
        setPanel("Buscar Placar por Equipes");

        JLabel lEquipe1 = new JLabel("ID da Equipe 1:");
        JTextField iEquipe1 = new JTextField(20);
        JLabel lEquipe2 = new JLabel("ID da Equipe 2:");
        JTextField iEquipe2 = new JTextField(20);
        JButton botao = new JButton("Buscar");

        // Configuração do layout com GridBagLayout
        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy = 0;
        c.add(lEquipe1, gbc);
        c.add(iEquipe1, gbc);

        gbc.gridy = 1;
        c.add(lEquipe2, gbc);
        c.add(iEquipe2, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        c.add(botao, gbc);

        // Label para erros
        gbc.gridy = 3;
        erroLabel.setForeground(Color.RED);
        c.add(erroLabel, gbc);

        // Adiciona uma área para exibir os resultados dinamicamente
        JPanel resultadoPanel = new JPanel(new GridBagLayout());
        gbc.gridy = 4;
        c.add(resultadoPanel, gbc);

        // Ação do botão Buscar
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    erroLabel.setText("");
                    resultadoPanel.removeAll();

                    int idEquipe1 = Integer.parseInt(iEquipe1.getText());
                    int idEquipe2 = Integer.parseInt(iEquipe2.getText());

                    Equipe equipe1 = Equipe.buscaEquipe(idEquipe1);
                    Equipe equipe2 = Equipe.buscaEquipe(idEquipe2);
                    Placar placar = Placar.buscaPlacar(equipe1, equipe2);

                    if (placar == null) {
                        throw new Exception("Nenhum PLACAR encontrado para essas equipes.");
                    }

                    GridBagConstraints resultGbc = new GridBagConstraints();
                    resultGbc.insets = new Insets(5, 5, 5, 5);
                    resultGbc.anchor = GridBagConstraints.WEST;

                    resultGbc.gridy = 0;
                    resultadoPanel.add(new JLabel("Equipe 1: " + placar.getEquipe1().getPais()), resultGbc);

                    resultGbc.gridy = 1;
                    resultadoPanel.add(new JLabel("Placar da Equipe 1: " + placar.getPlacarEquipe1()), resultGbc);

                    resultGbc.gridy = 2;
                    resultadoPanel.add(new JLabel("Equipe 2: " + placar.getEquipe2().getPais()), resultGbc);

                    resultGbc.gridy = 3;
                    resultadoPanel.add(new JLabel("Placar da Equipe 2: " + placar.getPlacarEquipe2()), resultGbc);

                    // Atualizar o layout com os novos componentes
                    resultadoPanel.revalidate();
                    resultadoPanel.repaint();
                } catch (NumberFormatException nfe) {
                    erroLabel.setText("IDs devem ser valores numéricos.");
                } catch (Exception ex) {
                    erroLabel.setText(ex.getMessage());
                }
            }
        });
    }

    // Método para listar todos os placares
    public void listarPlacares() {
        setPanel("Lista de Placares");

        JTable tabela;
        DefaultTableModel dados;

        // Cria o modelo da tabela
        dados = new DefaultTableModel(new String[]{"Equipe 1", "Pontos Equipe 1", " Pontos Equipe 2", "Equipe 2", "id Modalidade"}, 0);
        tabela = new JTable(dados);

        ArrayList<Placar> placares = Placar.listaTodosPlacares();
        for (Placar placar : placares) {
            dados.addRow(new Object[]{
                    placar.getEquipe1().getPais(),
                    placar.getPlacarEquipe1(),
                    placar.getPlacarEquipe2(),
                    placar.getEquipe2().getPais(),
                    placar.getEquipe1().getModalidade().getId()
            });
        }

        tabela.setAutoCreateRowSorter(true);
        tabela.setFillsViewportHeight(true);

        // Adiciona a tabela dentro de um JScrollPane (para rolagem)
        JScrollPane scrollPane = new JScrollPane(tabela);
        this.getContentPane().add(scrollPane);
        add(scrollPane, BorderLayout.CENTER);
    }
}
