// Class normal card
class Ncard extends Card{
    // inisialisasi
    private String CardName;
    private int CardCost = 0;
    private int Damage = 0;
	private int Heal = 0;
	private int Block = 0;
    
    // Mengganti/memberi nama
    void setCardName(String Name){
        this.CardName = Name;
    }
    // Mengambil nama
    String getCardName(){
        return this.CardName;
    }

    // Mengganti/memberi Card Cost
    void setCardCost(int CardCost){
        this.CardCost = CardCost;
    }
    // Mengambil Card Cost
    int getCardCost(){
        return this.CardCost;
    }

    // Mengganti/memberi Damage
    void setDamage(int Damage){
        this.Damage = Damage;
    }
    // Mengambil Damage
    int getDamage(){
        return this.Damage;
    }

    // Mengganti/memberi Heal
    void setHeal(int Heal){
        this.Heal = Heal;
    }
    // Mengambil Heal
    int getHeal(){
        return this.Heal;
    }

    // Mengganti/memberi Block
    void setBlock(int Block){
        this.Block = Block;
    }
    // Mengambil Block
    int getBlock(){
        return this.Block;
    }

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