import com.pandorabots.api.MagicParameters;
import com.pandorabots.api.PandorabotsAPI;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class Interfata {
	
	String response;
	
	public static String botName = "alice2";
	private JFrame frame;
	static MagicParameters mp = new MagicParameters();
	static PandorabotsAPI papi = new PandorabotsAPI(mp.getHostName(),
			mp.getAppId(), mp.getUserKey(), mp.isDebug());
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void createPapi() {
	try {
		papi.createBot(botName);
		papi.deleteBot(botName);
		papi.createBot(botName);
		papi.uploadFile(botName, "bot/udc.aiml");
		papi.uploadFile(botName, "bot/capsuni.aiml");
		papi.uploadFile(botName, "bot/ciocolata.aiml");
		papi.uploadFile(botName, "bot/gender.substitution");
		papi.uploadFile(botName, "bot/hello.aiml");
		papi.uploadFile(botName, "bot/invatare.aiml");
		papi.uploadFile(botName, "bot/normal.substitution");
		papi.uploadFile(botName, "bot/pand_initial.aiml");
		
		papi.uploadFile(botName, "bot/person.substitution");
		papi.uploadFile(botName, "bot/person2.substitution");
		papi.uploadFile(botName, "bot/peste.aiml");
		papi.uploadFile(botName, "bot/porc.aiml");
		papi.uploadFile(botName, "bot/pui.aiml");
		papi.uploadFile(botName, "bot/vanilie.aiml");
		papi.uploadFile(botName, "bot/botproiectia321.properties");
		papi.uploadFile(botName, "bot/denormal.substitution");
		papi.compileBot(botName);
		
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
			};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createPapi();
					Interfata window = new Interfata();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfata() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 724, 575);
		frame.getContentPane().add(tabbedPane);
		
		JPanel FelPrincipal = new JPanel();
		tabbedPane.addTab("Fel Principal", null, FelPrincipal, null);
		FelPrincipal.setLayout(null);
		
		JLabel lblIngrediente = new JLabel("Ingrediente Principale");
		lblIngrediente.setBounds(413, 132, 147, 14);
		FelPrincipal.add(lblIngrediente);
		
		final JCheckBox chckbxPui = new JCheckBox("Pui");	
		
		chckbxPui.setBounds(375, 166, 54, 23);
		FelPrincipal.add(chckbxPui);
		
		final JCheckBox chckbxPorc = new JCheckBox("Porc");
		chckbxPorc.setBounds(438, 166, 63, 23);
		FelPrincipal.add(chckbxPorc);
		
		final JCheckBox chckbxPeste = new JCheckBox("Peste");
		chckbxPeste.setBounds(503, 166, 99, 23);
		FelPrincipal.add(chckbxPeste);
		
		JLabel lblIngredienteSecundare = new JLabel("Ingrediente Secundare");
		lblIngredienteSecundare.setBounds(413, 217, 123, 14);
		FelPrincipal.add(lblIngredienteSecundare);
		
		final JCheckBox chckbxOrez = new JCheckBox("Orez");
		chckbxOrez.setBounds(375, 238, 54, 23);
		FelPrincipal.add(chckbxOrez);
		
		final JCheckBox chckbxPaste = new JCheckBox("Paste");
		chckbxPaste.setBounds(438, 238, 63, 23);
		FelPrincipal.add(chckbxPaste);
		
		final JCheckBox chckbxCartofi = new JCheckBox("Cartofi");
		chckbxCartofi.setBounds(503, 238, 99, 23);
		FelPrincipal.add(chckbxCartofi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 354, 415);
		FelPrincipal.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(chckbxPui.isSelected() && chckbxOrez.isSelected()) {
					String inputs[]= {"salut","da","fel principal","pui","orez"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				else if(chckbxPui.isSelected() && chckbxPaste.isSelected()) {
					String inputs[]= {"salut","da","fel principal","pui","paste"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				else if(chckbxPui.isSelected() && chckbxCartofi.isSelected()) {
					String inputs[]= {"salut","da","fel principal","pui","cartofi"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				
				if(chckbxPorc.isSelected() && chckbxOrez.isSelected()) {
					String inputs[]= {"salut","da","fel principal","porc","orez"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				else if(chckbxPorc.isSelected() && chckbxPaste.isSelected()) {
					String inputs[]= {"salut","da","fel principal","porc","paste"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				else if(chckbxPorc.isSelected() && chckbxCartofi.isSelected()) {
					String inputs[]= {"salut","da","fel principal","porc","cartofi"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				
				if(chckbxPeste.isSelected() && chckbxOrez.isSelected()) {
					String inputs[]= {"salut","da","fel principal","peste","orez"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				else if(chckbxPeste.isSelected() && chckbxPaste.isSelected()) {
					String inputs[]= {"salut","da","fel principal","peste","paste"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				else if(chckbxPeste.isSelected() && chckbxCartofi.isSelected()) {
					String inputs[]= {"salut","da","fel principal","peste","cartofi"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textArea.setText(response);
						
					}
				}
				
				
			}
		});
		btnEnter.setBounds(423, 294, 89, 23);
		FelPrincipal.add(btnEnter);
		
		JLabel lblRaspuns = new JLabel("Raspuns");
		lblRaspuns.setBounds(10, 88, 99, 14);
		FelPrincipal.add(lblRaspuns);
		
		
		
		JPanel Desert = new JPanel();
		tabbedPane.addTab("Desert", null, Desert, null);
		Desert.setLayout(null);
		
		JLabel lblRaspuns_1 = new JLabel("Raspuns");
		lblRaspuns_1.setBounds(10, 81, 83, 14);
		Desert.add(lblRaspuns_1);
		
		JLabel lblIngredientePrincipale = new JLabel("Ingrediente Principale");
		lblIngredientePrincipale.setBounds(450, 118, 124, 14);
		Desert.add(lblIngredientePrincipale);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(10, 107, 390, 382);
		Desert.add(textArea_1);
		
		final JCheckBox chckbxCiocolata = new JCheckBox("Ciocolata");
		chckbxCiocolata.setBounds(406, 139, 74, 23);
		Desert.add(chckbxCiocolata);
		
		final JCheckBox chckbxVanilie = new JCheckBox("Vanilie");
		chckbxVanilie.setBounds(482, 139, 65, 23);
		Desert.add(chckbxVanilie);
		
		final JCheckBox chckbxCapsuni = new JCheckBox("Capsuni");
		chckbxCapsuni.setBounds(548, 139, 100, 23);
		Desert.add(chckbxCapsuni);
		
		JLabel lblIngredienteSecundare_1 = new JLabel("Ingrediente Secundare");
		lblIngredienteSecundare_1.setBounds(450, 196, 160, 14);
		Desert.add(lblIngredienteSecundare_1);
		
		final JCheckBox chckbxOu = new JCheckBox("Ou");
		chckbxOu.setBounds(406, 217, 52, 23);
		Desert.add(chckbxOu);
		
		final JCheckBox chckbxFructe = new JCheckBox("Fructe");
		chckbxFructe.setBounds(482, 217, 65, 23);
		Desert.add(chckbxFructe);
		
		final JCheckBox chckbxFaina = new JCheckBox("Faina");
		chckbxFaina.setBounds(549, 217, 61, 23);
		Desert.add(chckbxFaina);
		
		JButton btnEnter_1 = new JButton("Enter");
		btnEnter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxCiocolata.isSelected() && chckbxOu.isSelected()) {
					String inputs[]= {"salut","da","desert","ciocolata","ou"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				else if(chckbxCiocolata.isSelected() && chckbxFructe.isSelected()) {
					String inputs[]= {"salut","da","desert","ciocolata","fructe"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				else if(chckbxCiocolata.isSelected() && chckbxFaina.isSelected()) {
					String inputs[]= {"salut","da","desert","ciocolata","faina"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				
				if(chckbxVanilie.isSelected() && chckbxOu.isSelected()) {
					String inputs[]= {"salut","da","desert","vanilie","ou"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				else if(chckbxVanilie.isSelected() && chckbxFructe.isSelected()) {
					String inputs[]= {"salut","da","desert","vanilie","fructe"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				else if(chckbxVanilie.isSelected() && chckbxFaina.isSelected()) {
					String inputs[]= {"salut","da","desert","vanilie","faina"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				
				}
				if(chckbxCapsuni.isSelected() && chckbxOu.isSelected()) {
					String inputs[]= {"salut","da","desert","capsuni","ou"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				else if(chckbxCapsuni.isSelected() && chckbxFructe.isSelected()) {
					String inputs[]= {"salut","da","desert","capsuni","fructe"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				else if(chckbxCapsuni.isSelected() && chckbxFaina.isSelected()) {
					String inputs[]= {"salut","da","desert","ciocolata","faina"};
					for (int i = 0; i < inputs.length; i++) {
						String request =inputs[i];
						try {
							response = papi.talk(botName, "user123", request);
						} catch (ClientProtocolException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (URISyntaxException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						textArea_1.setText(response);
						
					}
				}
				
				
			}
		});
		btnEnter_1.setBounds(450, 305, 112, 23);
		Desert.add(btnEnter_1);
		chckbxCiocolata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxCiocolata,chckbxVanilie,chckbxCapsuni);
			}
		});
		chckbxVanilie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxVanilie,chckbxCiocolata,chckbxCapsuni);
			}
		});
		chckbxCapsuni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxCapsuni,chckbxVanilie,chckbxCiocolata);
			}
		});
		chckbxOu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxOu,chckbxFaina,chckbxFructe);
			}
		});
		chckbxFaina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxFaina,chckbxOu,chckbxFructe);
			}
		});
		chckbxFructe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxFructe,chckbxOu,chckbxFaina);
			}
		});
		
		JPanel FreeChatPnl = new JPanel();
		tabbedPane.addTab("Free Chat", null, FreeChatPnl, null);
		FreeChatPnl.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 44, 699, 366);
		FreeChatPnl.add(scrollPane_1);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_2);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
					String request = textField.getText().toString();
					textField.setText("");
					try {
						textArea_2.append("\nHuman:"+request);
						textArea_2.append("\nRobot:"+papi.talk(botName,"user123", request));
						
					} catch (ClientProtocolException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		        }
			}
		});
		
		textField.setBounds(10, 414, 613, 55);
		FreeChatPnl.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String request = textField.getText().toString();
				textField.setText("");
				try {
					textArea_2.append("\nHuman:"+request);
					textArea_2.append("\nRobot:"+papi.talk(botName,"user123", request));
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSend.setBounds(620, 414, 89, 55);
		FreeChatPnl.add(btnSend);
		
		JLabel lblChatbox = new JLabel("ChatBox");
		lblChatbox.setBounds(10, 22, 89, 14);
		FreeChatPnl.add(lblChatbox);
		chckbxPui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxPui,chckbxPorc,chckbxPeste);
			}
		});
		chckbxPorc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxPorc,chckbxPui,chckbxPeste);
			}
		});
		chckbxPeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxPeste,chckbxPui,chckbxPorc);
			}
		});
		chckbxOrez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxOrez,chckbxPaste,chckbxCartofi);
			}
		});
		chckbxPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxPaste,chckbxOrez,chckbxCartofi);
			}
		});
		chckbxCartofi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setSelected(chckbxCartofi,chckbxOrez,chckbxPaste);
			}
		});
	}
	public void setSelected(JCheckBox chckbx1,JCheckBox chckbx2,JCheckBox chckbx3) {
		if(chckbx1.isSelected()) {
			chckbx2.setSelected(false);
			chckbx3.setSelected(false);
		}
		
	}
}
