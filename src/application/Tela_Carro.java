package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.entities.Carro;
import model.entities.carroController;

public class Tela_Carro implements ActionListener{
	
	JFrame tela = new JFrame("Cadastro de Veículos");
	JPanel painel = new JPanel();
	
	JLabel lbmodelo = new JLabel("Modelo: ");
	JTextField textModel = new JTextField();
	JLabel lbano = new JLabel("Ano: ");
	JTextField textAno = new JTextField();
	JLabel lbvalor = new JLabel("Valor: ");
	JTextField textVal = new JTextField();
	
	JButton salvar = new JButton("Salvar");
	JButton btlistar = new JButton("Listar");
	
	Carro car = new Carro();
	carroController cc = new carroController();
	
	String modelo = "";
	Integer ano = 0;
	Double valor = 0.0;

	
	void Tela() {
		
		tela.setSize(350, 250);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocation(250, 250);
		
		painel.setLayout(null);
		
		
		lbmodelo.setBounds(10, 10, 100, 30);
		painel.add(lbmodelo);
		
		textModel.setBounds(70, 15, 120, 20);
		painel.add(textModel);
		
		
		lbano.setBounds(10, 50, 100, 30);
		painel.add(lbano);
		
		
		textAno.setBounds(70, 55, 120, 20);
		painel.add(textAno);
		
	
		lbvalor.setBounds(10, 90, 100, 30);
		painel.add(lbvalor);
		
	
		textVal.setBounds(70, 95, 120, 20);
		painel.add(textVal);
		
		
		salvar.setBounds(10, 150, 75, 35);
		salvar.addActionListener(this);
		painel.add(salvar);
		
		
		btlistar.setBounds(90, 150, 75, 35);
		btlistar.addActionListener(this);
		painel.add(btlistar);
		
		tela.getContentPane().add(painel);
		tela.setVisible(true);
	}
	
	public static void main(String[] args) {
		Tela_Carro tp = new Tela_Carro();
		tp.Tela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == salvar) {
			modelo = textModel.getText();
			ano = Integer.parseInt(textAno.getText());
			valor = Double.parseDouble(textVal.getText());
			
			car.setModelo(modelo);
			car.setAno(ano);
			car.setValor(valor);
			
			cc.inserir(car);

			textModel.setText("");
			textAno.setText("");
			textVal.setText("");
		}
		
		if(e.getSource() == btlistar) {
			cc.listar();
		}
	}

}
