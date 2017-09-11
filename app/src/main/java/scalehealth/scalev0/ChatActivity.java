package scalehealth.scalev0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import co.devcenter.androiduilibrary.ChatView;

//import co.intentservice.chatui.ChatView;
//import co.intentservice.chatui.models.ChatMessage;

public class ChatActivity extends AppCompatActivity {

  // private ChatMessage initChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //initChat = new ChatMessage("You can now start chatting with Dr. Dinesh",System.currentTimeMillis(),ChatMessage.Type.RECEIVED);
      //  ChatView chatView = (ChatView) findViewById(R.id.chat_view);
        //chatView.newMessage("You can now start chatting with Dr. Dinesh");
        //chatView.receiveMessage("You can now start chatting with Dr. Dinesh");

    }

}
