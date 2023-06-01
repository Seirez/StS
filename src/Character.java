// Class character
class Character{
    // inisialisasi
    private String CharName;
    private int Health;
    private int Cblock;
    
    // Mengganti/memberi nama
    void setCharName(String Name){
        this.CharName = Name;
    }
    // Mengambil nama
    String getCharName(){
        return this.CharName;
    }

    // Mengganti/memberi hp
    void setHealth(int hp){
        this.Health = hp;
    }
    // Mengambil hp
    int getHealth(){
        return this.Health;
    }

    // Mengganti/memberi block
    void setCblock(int block){
        this.Cblock = block;
    }
    // Mengambil block
    int getCblock(){
        return this.Cblock;
    }

    // Reset block
    public int BlockReset(){
        int Block=0;
        return Block;
    }
    
    // Menghitung jumlah heal yang diterima
    public int heal(int hp,int heal){
        hp+=heal;
        return hp;
    }

    // Menghitung jumlah damage yang diterima
    public int damage(int hp,int dmg,int block){
        int temp=block;
        if (block<=0){
            hp-=dmg;
        }
        else{
            block-=dmg;
            if (block<0){
                block=0;
            }
            dmg-=temp;
            hp-=dmg;
        }
        return hp;
    }

    // Memperlihatkan deskripsi character
    public void showDesc(){
        System.out.println("Player\t: "+this.getCharName());
        System.out.println("HP  \t: "+this.getHealth());
        System.out.println("Block\t: "+this.getCblock());
    }
}