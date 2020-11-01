package com.ataccama.dbviewer.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class DbDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(example = "mysql_client3")
    private String name;

    @ApiModelProperty(example = "mysql_client3")
    private String hostname;

    @ApiModelProperty(example = "3309")
    private Integer port;

    @ApiModelProperty(example = "client_db3")
    private String databaseName;

    @ApiModelProperty(example = "db_viewer_user_3")
    private String username;

    @ApiModelProperty(example = "db_viewer_pass_3")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DbDetail)) return false;
        DbDetail dbDetail = (DbDetail) o;
        return Objects.equals(id, dbDetail.id) &&
                Objects.equals(name, dbDetail.name) &&
                Objects.equals(hostname, dbDetail.hostname) &&
                Objects.equals(port, dbDetail.port) &&
                Objects.equals(databaseName, dbDetail.databaseName) &&
                Objects.equals(username, dbDetail.username) &&
                Objects.equals(password, dbDetail.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hostname, port, databaseName, username, password);
    }

    @Override
    public String toString() {
        return "DbDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hostname='" + hostname + '\'' +
                ", port=" + port +
                ", databaseName='" + databaseName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
