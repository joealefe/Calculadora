import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleJavaServer {
	public static void main(String[] args) 	{
		try {
			ServerSocket s = new ServerSocket(9999);
			String str, n1, n2, n3, R = "";
			int N1 = 0, N2 = 0;
			while (true) {
				Socket c = s.accept();
				InputStream i = c.getInputStream();
				OutputStream o = c.getOutputStream();
				do {
					byte[] line = new byte[100];
					i.read(line);


					byte[] line2 = new byte[100];
					i.read(line2);


					byte[] line3 = new byte[100];
					i.read(line3);


					n1 = new String(line);
					n2 = new String(line2);
					n3 = new String(line3);


					if (!n1.trim().equals("+") && !n1.trim().equals("-") && !n1.trim().equals("*") && !n1.trim().equals("/")) {
						System.out.println("entrou");
						if (!n3.trim().equals("+") && !n3.trim().equals("-") && !n3.trim().equals("*") && !n3.trim().equals("/")) {
							N1 = Integer.valueOf(n1.trim());
							N2 = Integer.valueOf(n3.trim());
						} else {
							R = "INFORME UM NÚMERO";
						}

						if (n2.trim().equals("+") || n2.trim().equals("-") || n2.trim().equals("*") || n2.trim().equals("/")) {

							if (n2.trim().equals("+") && !n1.trim().equals("+") && !n3.trim().equals("+")) {
								N1 += N2;
								R = String.valueOf(N1);
							}

							if (n2.trim().equals("*") && !n1.trim().equals("*") && !n3.trim().equals("*")) {
								N1 *= N2;
								R = String.valueOf(N1);

							}

							if (n2.trim().equals("/") && !n1.trim().equals("/") && !n3.trim().equals("/")) {
								N1 /= N2;
								R = String.valueOf(N1);

							}
							if (n2.trim().equals("-") && !n1.trim().equals("-") && !n3.trim().equals("-")) {
								N1 -= N2;
								R = String.valueOf(N1);

							}
						} else {
							R = "Digite um operador valido";
						}
					}else {
					R = "INFORME UM NÚMERO";
					}



				o.write(R.trim().getBytes());
					str = new String(R);
				} while ( !str.trim().equals("bye") );
				c.close();
			}
		}
		catch (Exception err){
		   System.err.println(err);
		}
	}
}
