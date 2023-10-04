package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// DB接続確認
@RestController
@RequestMapping("/check-db-connection")
public class DB {

    @GetMapping
    public String checkDatabaseConnection() {
        try {
            // PostgreSQLのJDBCドライバを使用してデータベースに接続を試みる
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JavaTeamDevelopment", "postgres", "jwe0x3eh");
            
            // データベースに接続が成功した場合の処理
            connection.close();
            return "データベース接続に成功しました。";
        } catch (ClassNotFoundException e) {
            return "JDBCドライバが見つかりません。";
        } catch (SQLException e) {
            return "データベース接続に失敗しました。エラーメッセージ: " + e.getMessage();
        }
    }
}