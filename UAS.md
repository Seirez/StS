# No 1
Use case user  
Menu
- Play
    - Pilih character
        - Pilih ascension (difficulty)
            - Map (encounters)
                - Map randomization
                    - Random event
                    - Enemy encounter
                        - Normal
                        - Boss
                        - Elite
                    - Peaceful encounter
                        - Trader
                        - Chest
                        - Campfire

                - Pilih encounter

                - Battle
                    - Pilih card (action)
                        - Normal card
                        - Colorless card
                        - Status card
                        - Curse card
                    - Energy consumption
                    - End turn
                        - Energy reset
                        - Block reset (to 0)
                        - Enemy action
                    - Battle end (Reward)

                - Standard campaign end (Unlocking new relics and more)
    - Daily climb
    - Custom

- Compedium
- Statistics
- Settings
- Patch notes
- Exit

Use case manajemen perusahaan
- Change daily climb level
- Database management
    - C (create/input)
    - R (read/retrieve)
    - U (update)
    - D (delete)

Use case direksi perusahaan
- view player statistic (which character that is being used the most and more)


# No 2
![image](https://github.com/Seirez/StS/assets/94272100/c2ae60e9-56c0-403d-9618-b1e42369b596)


# No 3
1. Single Responsibility Principle (SRP):  
Prinsip ini menyatakan bahwa sebuah kelas hanya harus memiliki satu alasan untuk berubah, artinya kelas tersebut memiliki tanggung jawab tunggal. Prinsip ini mendorong koherensi tinggi dan keterkaitan rendah, sehingga membuat kelas lebih mudah dipahami dan dipelihara. Untuk mengikuti SRP, Anda harus merancang kelas yang memiliki satu tujuan atau tanggung jawab.  
- Contoh penggunaannya adalah Class MenuUI yang hanya bertanggung jawab untuk membuka sebuah UI.
   
2. Open/Closed Principle (OCP):  
OCP menyatakan bahwa entitas perangkat lunak (kelas, modul, fungsi) harus terbuka untuk perluasan namun tertutup untuk modifikasi. Ini berarti Anda harus dapat menambahkan fungsionalitas baru ke dalam sistem tanpa mengubah kode yang sudah ada. Untuk mengikuti OCP, Anda dapat menggunakan teknik seperti abstraksi, pewarisan, dan antarmuka untuk merancang sistem yang fleksibel dan dapat diperluas.  
- Contoh penggunaannya adalah Abstract Class Status yang merupakan superclass dari Buff dan Debuff, dimana kita tidak mengubah kode yang sudah ada untuk menambahkan fungsi baru.

3. Liskov Substitution Principle (LSP):  
LSP menekankan bahwa objek dari superclass harus dapat diganti dengan objek dari subclass-nya tanpa mengganggu kebenaran sistem. Dengan kata lain, subclass harus dapat menggantikan kelas dasar mereka tanpa mengubah perilaku sistem secara keseluruhan. Dengan mengikuti LSP, Anda memastikan bahwa kode Anda dirancang dengan hierarki pewarisan yang tepat dan menghindari masalah yang tidak terduga saat menggantikan objek.  
- Contoh penggunaannya adalah Class Entitiy yang merupakan superclass dari Character dan Enemy, dimana kita dapat melakukan overrride terhadap method yang ada pada superclass.

4. Interface Segregation Principle (ISP):  
ISP menyatakan bahwa klien tidak boleh dipaksa untuk bergantung pada antarmuka yang tidak mereka gunakan. Alih-alih membuat antarmuka besar dan monolitik, lebih baik memiliki antarmuka yang lebih kecil dan lebih fokus yang disesuaikan dengan klien tertentu. Prinsip ini membantu mencegah kode klien terpengaruh oleh perubahan pada metode antarmuka yang tidak relevan.  
- Prinsip ini diterapkan secara langsung dengan penggunaan library java swing yang memberikan interface JFrame, dimana kita tidak perlu menggunakan semua methodnya.

5. Dependency Inversion Principle (DIP):  
DIP menyatakan bahwa modul-level tinggi tidak boleh bergantung pada modul-level rendah; keduanya harus bergantung pada abstraksi. Prinsip ini mendorong keterkaitan yang longgar dan memungkinkan penggantian implementasi yang lebih mudah. Dengan memprogram menggunakan antarmuka atau kelas abstrak daripada implementasi konkret, Anda dapat mencapai fleksibilitas dan keujiabilitas yang lebih baik dalam kode Anda.  

# No 4
Class DatabaseConnection memiliki beberapa aspek dari "Data Access Object" design pattern, dimana class tersebut menangani operasi database tingkat rendah. Class ini mengenkapsulasi detail-detail pembuatan koneksi, eksekusi kueri SQL, dan penanganan hasil kueri. Metode-metode dalam kelas ini mengabstraksi kompleksitas operasi database dan menyediakan antarmuka yang disederhanakan bagi komponen-komponen lain dalam aplikasi untuk berinteraksi dengan database.  
Tetapi Class tersebut tidak memiliki pola DAO yang biasanya melibatkan abstraksi tambahan, seperti antarmuka atau kelas terpisah untuk akses data.

# No 5
https://github.com/Seirez/StS/blob/main/src/DatabaseConnection.java
![code](https://github.com/Seirez/StS/assets/94272100/01e29364-2c36-40c9-b0e4-d9de07397f65)


# No 6
https://github.com/Seirez/StS/blob/main/src/DatabaseConnection.java
https://github.com/Seirez/StS/blob/main/src/API.java
![code](https://github.com/Seirez/StS/assets/94272100/01e29364-2c36-40c9-b0e4-d9de07397f65)
![code2](https://github.com/Seirez/StS/assets/94272100/3aa94099-5e7b-4a6b-a2c4-69fdc5a042bf)


# No 7
https://github.com/Seirez/StS/blob/main/src/MenuUI.java
https://github.com/Seirez/StS/blob/main/src/CharacterSelectionUI.java
https://github.com/Seirez/StS/blob/main/src/PlayUI.java
![71](https://github.com/Seirez/StS/assets/94272100/18c87302-080e-4225-9c04-6a9bf3646323)
![72](https://github.com/Seirez/StS/assets/94272100/ce45a02b-16f8-46a5-bda5-4fce339030af)
![73](https://github.com/Seirez/StS/assets/94272100/4188d67a-a001-4b23-8595-dee1139342a9)


# No 8
https://github.com/Seirez/StS/blob/main/src/API.java
https://github.com/Seirez/StS/blob/main/src/CharacterSelectionUI.java
![code2](https://github.com/Seirez/StS/assets/94272100/3aa94099-5e7b-4a6b-a2c4-69fdc5a042bf)
![72](https://github.com/Seirez/StS/assets/94272100/ce45a02b-16f8-46a5-bda5-4fce339030af)

# No 9
![Animation1](https://github.com/Seirez/StS/assets/94272100/8b6e3ae3-ff01-4cd3-97cc-3a51aa2154b7)


# No 10
