package chess.repository;

import chess.domain.room.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RoomRepository {
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";

    private final Connection connection;

    public RoomRepository(Connection connection) {
        this.connection = Objects.requireNonNull(connection, "DB에 연결되지 않았습니다.");
    }

    public List<Room> findAllRooms() throws SQLException {
        String query = "SELECT * FROM ROOM";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return generateRoomsFrom(resultSet);
    }

    private List<Room> generateRoomsFrom(ResultSet resultSet) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString(ID_COLUMN));
            String name = resultSet.getString(NAME_COLUMN);
            Room room = new Room(id, name);
            rooms.add(room);
        }
        return rooms;
    }

    public void insertRoom(String roomName) throws SQLException {
        String query = "INSERT INTO ROOM (NAME) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, roomName);
        preparedStatement.executeUpdate();
    }

    public Optional<Room> findLatestRoom() throws SQLException {
        String query = "SELECT * FROM ROOM ORDER BY ID DESC LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return Optional.empty();
        }
        int id = Integer.parseInt(resultSet.getString(ID_COLUMN));
        String name = resultSet.getString(NAME_COLUMN);
        Room room = new Room(id, name);
        return Optional.of(room);
    }
}
