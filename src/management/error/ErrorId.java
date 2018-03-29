package management.error;

import javax.swing.JOptionPane;

public class ErrorId {
       
	public void MSGAP18021601() {
		JOptionPane.showMessageDialog(null, "該当データがありません", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021602() {
		JOptionPane.showMessageDialog(null, "従業員が未入力です", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021603() {
		JOptionPane.showMessageDialog(null, "従業員区分が未入力です", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021604() {
		JOptionPane.showMessageDialog(null, "従業員名が未入力です", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021605() {
		JOptionPane.showMessageDialog(null, "連絡先が未入力です", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021606() {
		JOptionPane.showMessageDialog(null, "削除する行が選択されていません", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021607() {
		JOptionPane.showMessageDialog(null, "ファイルのフォーマットが間違っています", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021608() {
		JOptionPane.showMessageDialog(null, "ファイルが読み込めませんでした", "message added",JOptionPane.PLAIN_MESSAGE);
	}
	public void MSGAP18021609() {
		JOptionPane.showMessageDialog(null, "従業員データを全削除し、ファイルの内容を登録します", "message added",JOptionPane.PLAIN_MESSAGE);
	}
}
