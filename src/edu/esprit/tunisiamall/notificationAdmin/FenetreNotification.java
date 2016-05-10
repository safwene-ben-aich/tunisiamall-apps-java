package edu.esprit.tunisiamall.notificationAdmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JWindow;


/**
 * <b>FenetreNotification est la classe qui permet de d�finir la fen�tre de notification des messages</b>
 * <p>
 * Cette classe est caract�ris�e par les informations suivantes :
 * <ul>
 * <li>Le titre du message</li>
 * <li>Le texte du message</li>
 * <li>Le type de notification</li>
 * </ul>
 * </p>
 * <p>
 * Cette classe h�rite de JWindow
 * </p>
 * 
 * @see fr.julien.notification.TypeNotification
 * 
 * @author Julien
 * @version 1.0
 *
 */
public class FenetreNotification extends JWindow {

	/**
	 * identifiant pour la s�rialisation
	 */
	private static final long serialVersionUID = 227309878747520841L;

	/**
	 * <b>Constructeur de la fen�tre de notification</b>
	 * @param titre
	 * 	Le titre de la fen�tre
	 * @param texte
	 * 	Le texte � afficher
	 * @param type
	 * 	Le type de notification
	 * 	@see fr.julien.notification.TypeNotification
	 */
	public FenetreNotification(String titre, String texte, TypeNotification type){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize().getSize();
		setAlwaysOnTop(true);
		setSize(160, 100);
		JPanel panel = new PanelGradient(type.getCouleur1(), type.getCouleur2());
		panel.setBorder(BorderFactory.createEtchedBorder(1, Color.darkGray, Color.MAGENTA));
		panel.setLayout(new BorderLayout());
		JEditorPane p = new JEditorPane();
		p.setOpaque(false);
		p.setContentType("text/html");
		p.setText(genereHtml(titre, texte));
		panel.add(p);
		add(panel);
		setLocation((int)d.getWidth()-180, (int)d.getHeight()-150);
	}
	
	/**
	 * Cette fonction permet de g�n�rer le code du JEditorPane
	 * @param titre
	 * 	Le titre de la fen�tre
	 * @param texte
	 * 	Le texte � afficher
	 * @return le code permettant de placer le texte dans le JEditorPane
	 */
	private String genereHtml(String titre, String texte){
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body style='font-family:Calibri;font-size:10px;'>");
		sb.append("<table border='1px' width='100%'>");
		sb.append("<tr>");
		sb.append("<th style='font-size:13px;font-weight:bold;' align='center'>");
		sb.append(titre+"<hr />");
		sb.append("</th>");
		sb.append("</tr>");
		sb.append("	<tr>");
		sb.append("	<td align='center'>");
		sb.append(texte);
		sb.append("</td>");
		sb.append("	</tr>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("	</html>");
		return sb.toString();
	}

}
