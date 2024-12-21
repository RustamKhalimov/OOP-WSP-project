
public interface SendMassage {
	void readMessage(String messageTitle);

    void sendMessage(String title,String importanceLevel,String message,String date);

    void sendComplain(String title,String importanceLevel,String complain,String date);
    


}
