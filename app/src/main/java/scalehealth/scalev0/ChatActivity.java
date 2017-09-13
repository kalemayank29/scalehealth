package scalehealth.scalev0;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.smooch.core.Smooch;
import io.smooch.ui.ConversationActivity;

//import co.devcenter.androiduilibrary.ChatView;

//import co.intentservice.chatui.ChatView;
//import co.intentservice.chatui.models.ChatMessage;

public class ChatActivity extends AppCompatActivity {

  // private ChatMessage initChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ConversationActivity.show(this);
        //02dtlsm8hi2b22woayehjsxk2

        //initChat = new ChatMessage("You can now start chatting with Dr. Dinesh",System.currentTimeMillis(),ChatMessage.Type.RECEIVED);
      //  ChatView chatView = (ChatView) findViewById(R.id.chat_view);
        //chatView.newMessage("You can now start chatting with Dr. Dinesh");
        //chatView.receiveMessage("You can now start chatting with Dr. Dinesh");

    }

}
