import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;


public class Player1 extends Player {
    public Player1(Card[] cards){this.hand = new ArrayList<Card>(Arrays.asList(cards));}
    @Override
    public boolean play(DiscardPile discardPile,Stack<Card> drawPile,ArrayList<Player> players) {
        ExtraCards();
        discardPile.add(this.hand.remove(0));
        if (this.hand.size() == 0) {
            return true;
        }return false;
    }
    // will pick cards until it gets the power card
    public boolean ExtraCards() {
        DiscardPile discardPile = new DiscardPile();
        Stack<Card> ExtraCard = new Stack<Card>();
        Player[] players = new Player[3];
        ArrayList<Player> player= new ArrayList<>();
        //index of player setter
        int indexOfNextPlayer=player.indexOf(players)+1;
        if (indexOfNextPlayer > player.size()) {
            indexOfNextPlayer=0;}

        //checks if the next player card size is equal to 1
        if (players[indexOfNextPlayer].getSizeOfHand() == 1) {

            if (this.getSizeOfHand() != 0) {
                for (int i = 0; i < hand.size(); i++) {
                    //checks if power card number two exist is in hands
                    if (hand.get(i).getRank() == 2) {
                        //cheeks the suit of the card in hand and the discarded card on the top
                        if(hand.get(i).getSuit()==discardPile.top().getSuit()){
                        hand.add(0,hand.remove(i));
                        play(discardPile,ExtraCard,player);
                        //return card 2
                        return true;}
                    }
                    //checks if power card number Jack exist is in hands
                    else if (hand.get(i).getRank() == 11) {
                        //cheeks the suit of the card in hand and the discarded card on the top
                        if(hand.get(i).getSuit()==discardPile.top().getSuit()){
                        hand.add(0,hand.remove(i));
                        play(discardPile,ExtraCard,player);
                        //return card 11
                        return true;}
                    }
                    //checks if power card number eight exist is in hands
                    else if (hand.get(i).getRank() == 8) {
                        hand.add(0,hand.remove(i));
                        play(discardPile,ExtraCard,player);
                        //return card 8
                        return true;}
                    }
                }
            } else {
                //pick card from pile until it gets the power cards
                while (true) {
                    //

                    Card drawpile = pickupCard(ExtraCard);
                    //check the drawPile is a power card
                    if (drawpile.getRank() == 2) {
                        //it will check if the top discarded card suit is the same as the new draw card suit
                        if (discardPile.top().getSuit() == drawpile.getSuit()) {
                            play(discardPile, ExtraCard, player);
                            break;
                        }
                        continue;
                    } else if (drawpile.getRank() == 11) {
                        //it will check if the top discarded card suit is the same as the new draw card suit
                        if (discardPile.top().getSuit() == drawpile.getSuit()) {
                            play(discardPile, ExtraCard, player);
                            break;
                        }
                        continue;
                    } else if (drawpile.getRank() == 8) {
                        play(discardPile, ExtraCard, player);
                        break;
                        }
                    // continue the loop until it gets the power cards
                    continue;
                }
                //return true if the loop breaks;
                return true;
            }


        // return false if player doesn't left with one card
        return false;
    }
}