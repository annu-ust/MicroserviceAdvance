package com.example.chatapp.model;

/*we need to create a message to send.

The endpoint will accept messages containing the sender name and a text in a STOMP message whose body is a JSON object.

The message might look like this:

{
    "from": "John",
    "text": "Hello!"
}*/
//To model the message carrying the text,
//we can create a simple Java object with from and text properties:
public class ChatMessage {
	private String content;
    private String sender;
    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
    
}
//By default, Spring will use the Jackson library 
//to convert our model object to and from JSON.