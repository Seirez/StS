// Class enemy inherit class character
class Enemy extends Character{
    // Override method
    // Memperlihatkan deskripsi enemy
    public void showDesc(){
        System.out.println("Enemy\t: "+this.getCharName());
        System.out.println("HP  \t: "+this.getHealth());
        System.out.println("Block\t: "+this.getCblock());
    }
}