package com.example.networkdemo;

import java.io.Serializable;

public class GameRoom implements Serializable {
    String room_id;
    HumanPlayer player1;
    HumanPlayer player2;



    public GameRoom(int creatorNo, String mode)
    {

        // create a random string for room id
        // ****************** will do
        // TEMP:
        room_id = generateRoomID(7);
        // set first player (room creator)
        // assign token X
        setPlayer1(creatorNo);

        if (mode == "multi") {
            player2 = new HumanPlayer(""); // for multigame, when room is created, player2 is empty
        }
        if (mode == "solo")
            setPlayer2AsComputer(creatorNo); // for sologame, when room is created, player2 is AI
    }

    public String getRoomID() { return room_id; }
    public HumanPlayer getPlayer1() { return player1; }
    public HumanPlayer getPlayer2() { return player2; }

    public void setPlayer1(int playerNo) {
        player1 = new HumanPlayer("Player " + playerNo);
        player1.setToken('X');  // always assign token x for player 1
        player1.setRoom_id(room_id);
    }

    public void setPlayer2(int playerNo) {
        player2 = new HumanPlayer("Player " + playerNo);
        player2.setToken('O'); // always assign token o for player 2
        player2.setRoom_id(room_id);
    }

    public void setPlayer2AsComputer(int playerNo) {
        player2.setUserName("Computer " + playerNo);
        player2.setToken('O');
        player2.setRoom_id(room_id);
    }

    public void resetPlayer(HumanPlayer player) {
        if (player1.getUserName() == player.getUserName())
            player1.setUserName("");
        else if (player2.getUserName() == player.getUserName())
            player2.setUserName("");
        else
            System.out.println("This player is not in this room");
    }

    // function to generate a random string of length n
    String generateRoomID(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}