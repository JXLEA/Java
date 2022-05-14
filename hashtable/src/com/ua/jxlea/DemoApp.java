package com.ua.jxlea;

import java.util.List;

public class DemoApp {

  public static void main(String[] args) {
    var names =
        List.of(
            "Andrii",
            "Serhii",
            "Nazar",
            "Taras",
            "Stas",
            "Yurii",
            "Tetiana",
            "Valerii",
            "Victoriai");
    var namesTable = new HashTable<String>();
    names.forEach(namesTable::add);
    namesTable.printTable();
  }
}
