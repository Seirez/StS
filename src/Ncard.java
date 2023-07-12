// Class normal card
class Ncard extends Card{

    public Ncard(String CardName, int CardCost, int Damage, int Heal, int Block) {
        setCardName(CardName);
        setCardCost(CardCost);
        setDamage(Damage);
        setHeal(Heal);
        setBlock(Block);
    }

    // Memperlihatkan deskripsi card
    public Card show() {
        System.out.println("("+this.getCardCost()+") "+this.getCardName());

        // Hanya di-eksekusi bila tidak 0
        if(getDamage()!=0){
            System.out.println("Deal "+this.getDamage()+" damage");
        }
        if(getHeal()!=0){
            System.out.println("Heal "+this.getHeal()+" HP");
        }
        if(getBlock()!=0){
            System.out.println("Gain "+this.getBlock()+" Block");
        }
        return null;
    }

    // Overloading method
    // Show current energy
    public void showHistory(int energy) {
        System.out.println("Energy : "+energy);
    }

    // Show damage dealt
    public void showHistory(String name,int damage) {
        System.out.println(name+" deals "+damage+" damage");
    }

    // Show healing amount
    public void showHistory(String name,int hp,int heal) {
        System.out.println(name+" healed for "+heal+" HP to "+hp+" HP");
    }

    // Show blocking amount
    public void showHistory(int cblock, int block) {
        System.out.println("Block increased by "+block+" to "+(cblock+block)+" Block");
    }
}