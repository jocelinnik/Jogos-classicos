package br.com.violenciatech.jogos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import br.com.violenciatech.jogos.asteroids.Asteroids;
import br.com.violenciatech.jogos.asteroidssprites.Asteroidssprites;
import br.com.violenciatech.jogos.cobrinha.Cobrinha;
import br.com.violenciatech.jogos.pacman.Pacman;
import br.com.violenciatech.jogos.pacmansprites.Pacmansprites;
import br.com.violenciatech.jogos.spaceinvader.Spaceinvader;
import br.com.violenciatech.jogos.tetris.Tetris;

public class Tela extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int JANELA_LARGURA = 300;
	private static final int JANELA_ALTURA = 350;
	
	private JTabbedPane painel; 
	private JPanel tela, painel1, painel2, painel3, painel4, painel5, painel6, painel7;
	private JButton botao1, botao2, botao3, botao4, botao5, botao6, botao7;
	private ImageIcon icone1, icone2, icone3, icone4, icone5, icone6, icone7;
	
	public Tela() {
		inicializaGifs();
		inicializaBotoes();
		ativaGamesBotoes();
		inicializaPaineis();
		
		tela = new JPanel();
		tela.setPreferredSize(new Dimension(JANELA_LARGURA, JANELA_ALTURA));
		tela.setBorder(new TitledBorder("Selecione um game para jogar"));
		tela.setLayout(new BoxLayout(tela, BoxLayout.Y_AXIS));
		
		painel = new JTabbedPane();
		painel.add("Asteroids", painel1);
		painel.add("Asteroids - Sprite version", painel2);
		painel.add("Pacman", painel3);
		painel.add("Pacman - Sprite version", painel4);
		painel.add("Tetris", painel5);
		painel.add("Cobrinha do Nokia", painel6);
		painel.add("Space Invader", painel7);
		
		tela.add(painel);
		setTitle("Arcade simples");	
		getContentPane().add(tela);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		pack();
		setVisible(true);
		tela.repaint();
	}
	
	public void inicializaGifs() {
		icone1 = new ImageIcon("imagens/icones/asteroids.gif");
		icone2 = new ImageIcon("imagens/icones/asteroidssprites.gif");
		icone3 = new ImageIcon("imagens/icones/pacman.gif");
		icone4 = new ImageIcon("imagens/icones/pacmansprites.gif");
		icone5 = new ImageIcon("imagens/icones/tetris.gif");
		icone6 = new ImageIcon("imagens/icones/snakenokia.gif");
		icone7 = new ImageIcon("imagens/icones/spaceinvader.gif");
	}
	
	public void inicializaBotoes() {
		botao1 = new JButton(icone1);
		botao2 = new JButton(icone2);
		botao3 = new JButton(icone3);
		botao4 = new JButton(icone4);
		botao5 = new JButton(icone5);
		botao6 = new JButton(icone6);
		botao7 = new JButton(icone7);
	}
	
	public void ativaGamesBotoes() {
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Asteroids.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Asteroidssprites.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Pacman.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
		botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Pacmansprites.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
		botao5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Tetris.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
		botao6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Cobrinha.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
		
		botao7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				new Thread() {
					public void run() {
						try {
							Spaceinvader.executar();
						}catch(RuntimeException e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		});
	}
	
	public void inicializaPaineis() {
		painel1 = new JPanel();
		painel2 = new JPanel();
		painel3 = new JPanel();
		painel4 = new JPanel();
		painel5 = new JPanel();
		painel6 = new JPanel();
		painel7 = new JPanel();

		painel1.add(botao1);
		painel2.add(botao2);
		painel3.add(botao3);
		painel4.add(botao4);
		painel5.add(botao5);
		painel6.add(botao6);
		painel7.add(botao7);
	}
}