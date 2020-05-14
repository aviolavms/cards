public class Deck {

    String crntSuit;

    String crntRank;

    int curtValue;

    Card[] allCards;

    Card[] shufCards;

    int value = 0;

    boolean ranBefore;

    int pos;

    public Deck(){

        allCards = new Card[52];

        for(int i = 0; i<12; i++){
            if(i==0){
                crntRank = "2";
            }else if(i==1){
                crntRank = "3";
            }else if(i==2){
                crntRank = "4";
            }else if(i==3){
                crntRank = "5";
            }else if(i==4){
                crntRank = "6";
            }else if(i==5){
                crntRank = "7";
            }else if(i==6){
                crntRank = "8";
            }else if(i==7){
                crntRank = "9";
            }else if(i==8){
                crntRank = "10";
            }else if(i==9){
                crntRank = "Jack";
            }else if(i==10){
                crntRank = "Queen";
            }else if(i==11){
                crntRank = "King";
            }else{
                crntRank = "Ace";
            }
            for(int n = 0; n<3; n++){

                if(n==0) {
                    allCards[value] = new Card("Clubs", crntRank,i+2);
                    value++;
                }else if(n==1){
                    allCards[value] = new Card("Hearts",crntRank, i+2);
                    value++;
                }else if(n==2){
                    allCards[value] = new Card("Spades", crntRank,i+2);
                    value++;
                }else{
                    allCards[value] = new Card("Diamonds", crntRank,i+2);
                    value++;
                }
            }
        }
    }
    public void shuffle(){

        shufCards = new Card[52];

        if(ranBefore==true){
            for (int i = 0; i < 52; i++) {
                allCards[i] = shufCards[i];
            }
        }

        int randomVal;

        boolean found;

        ranBefore = true;

        for(int i = 0; i<52; i++){
            found=false;
            while(found==false){
                randomVal = (int)((Math.random()*52));
                if(allCards[randomVal].getValue()!=-1){
                    shufCards[i] = allCards[randomVal];
                    allCards[randomVal] = new Card("null", "null", -1);
                    found = true;
                }
            }
        }
    }
    public Card deal(){
        if(pos == 52){
            return(null);
        }else if(ranBefore == false){
            return(allCards[pos]);
            pos++;
        }else{
            return(shufCards[pos]);
            pos++;
        }
    }
}

