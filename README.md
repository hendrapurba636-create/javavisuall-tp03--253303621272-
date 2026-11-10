# Character Manager — TP3 (Java Visual SIH-6406)

## Deskripsi Project

Character Manager adalah program berbasis Java yang digunakan untuk mengelola data karakter dalam sebuah aplikasi sederhana. Program ini menerapkan konsep Object-Oriented Programming (OOP), seperti encapsulation, constructor, enum, getter dan setter, serta method untuk mengelola atribut karakter.

Pada TP3 ini, program dikembangkan dengan menambahkan atribut `mana`, validasi nilai mana, dan method `isAlive()` untuk memeriksa apakah karakter masih hidup berdasarkan nilai hit points (HP).

## Fitur

- Membuat objek karakter menggunakan dua constructor.
- Menggunakan `CharacterType` untuk menentukan jenis karakter.
- Mengelola atribut karakter menggunakan encapsulation.
- Melakukan perubahan level karakter.
- Menghitung kembali HP dan attack berdasarkan level.
- Menyimpan atribut `mana` dengan validasi agar tidak bernilai negatif.
- Memeriksa status hidup karakter menggunakan `isAlive()`.
- Menampilkan informasi karakter menggunakan `toString()`.

## Screenshot Output Program

Berikut adalah bukti hasil program Character Manager yang dijalankan melalui terminal.

![Screenshot Output Character Manager](screenshot/output.png)

*Catatan: Ganti gambar di atas dengan screenshot terminal milikmu yang menampilkan tiga karakter, demo level up, serta hasil pemanggilan `isAlive()`.*

## Struktur Folder Project

```text
CharacterManager/
├── src/
│   ├── com/
│   │   └── unpri/
│   │       └── charactermanager/
│   │           └── model/
│   │               ├── Character.java
│   │               └── CharacterType.java
│   └── Main.java
├── screenshots/
│   └── output.png
└── README.md
```

*Catatan: Struktur di atas merupakan contoh. Sesuaikan dengan struktur folder project yang benar-benar kamu gunakan.*

## Identitas Mahasiswa

- **Nama Lengkap:** [Hendra Lampita Purba]
- **NIM:** [253303621272]
- **Kelas:** [3 Pagi B]
- **Mata Kuliah:** Java Visual SIH-6406


## Dokumentasi Analisis Desain

Dokumen analisis desain dan ekosistem Java untuk Bagian D dapat diakses melalui Google Docs berikut:

https://docs.google.com/document/d/1R-qgvV7pJYBEpoJwBTIROjb3eyhRu5bwnFcKhvuADbQ/edit?usp=sharing