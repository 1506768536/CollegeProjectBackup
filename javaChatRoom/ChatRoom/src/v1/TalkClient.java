package v1;

import java.io.*;
import java.net.*;
public class TalkClient {
	public static void main(String args[]) {
		try{
			//�򱾻���4700�˿ڷ����ͻ�����
			Socket socket=new Socket("127.0.0.1",4700);
			//��ϵͳ��׼�����豸����BufferedReader����
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			//��Socket����õ��������������PrintWriter����
			PrintWriter os=new PrintWriter(socket.getOutputStream());
			//��Socket����õ�����������������Ӧ��BufferedReader����
			BufferedReader is=new BufferedReader(new 
				InputStreamReader(socket.getInputStream()));
			String readline;
			readline=sin.readLine(); //��ϵͳ��׼�������һ�ַ���
			while(!readline.equals("bye")){//���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
				//����ϵͳ��׼���������ַ��������Server
				os.println(readline);
				os.flush();//ˢ���������ʹServer�����յ����ַ���
				//��ϵͳ��׼����ϴ�ӡ������ַ���
				System.out.println("Client:"+readline);
				//��Server����һ�ַ���������ӡ����׼�����
				System.out.println("Server:"+is.readLine());				
				readline=sin.readLine(); //��ϵͳ��׼�������һ�ַ���
			} //����ѭ��
			os.close(); //�ر�Socket�����
			is.close(); //�ر�Socket������
			socket.close(); //�ر�Socket
		}catch(Exception e) {
			System.out.println("Error"+e); //���������ӡ������Ϣ
	    }
	}
}