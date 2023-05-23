import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarportMapper {

    private ThreeDPrintDB database;

    public CarportMapper(ThreeDPrintDB database) {
        this.database = database;
    }
    public  List<Carport> selectCarportsFromOrderId(int orderId) {



        List<Carport> carportList = new ArrayList<>();

        String sql = "SELECT * FROM carport INNER JOIN itemlistrem on carport.carport_id = itemlistrem.carport_id\n" +
                "INNER JOIN itemlistspaer on carport.carport_id = itemlistspaer.carport_id\n" +
                "INNER JOIN itemlisttag on carport.carport_id = itemlisttag.carport_id\n" +
                "INNER JOIN itemliststolpe on carport.carport_id = itemliststolpe.carport_id\n" +
                "INNER JOIN rem on rem.rem_id = itemlistrem.rem_id\n" +
                "INNER JOIN spaer on spaer.spaer_id = itemlistspaer.spaer_id\n" +
                "INNER JOIN tag on tag.tag_id = itemlisttag.tag_id\n" +
                "INNER JOIN stolpe on stolpe.stolpe_id = itemliststolpe.stolpe_id WHERE carport.order_id = ?";

        try (Connection connection = database.connect()){

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int carportId = rs.getInt("carport_id");
                    double width = rs.getDouble("width");
                    double length = rs.getDouble("length");
                    double height = rs.getDouble("height");
                    boolean shed = rs.getBoolean("shed");
                    Spaer spaer = new Spaer(rs.getInt("spaer_id"), rs.getString("spaer_name"), rs.getDouble("spaer.length"), rs.getInt("spaer.price"),rs.getInt("itemlistspaer.quantity"));
                    Rem rem = new Rem(rs.getInt("rem_id"), rs.getString("rem_name"), rs.getDouble("rem.length"), rs.getInt("rem.price"),rs.getInt("itemlistrem.quantity"));
                    Stolpe stolpe = new Stolpe(rs.getInt("stolpe_id"), rs.getString("stolpe_name"), rs.getDouble("stolpe.length"), rs.getInt("stolpe.price"),rs.getInt("itemliststolpe.quantity"));
                    Tag tag = new Tag(rs.getInt("tag_id"), rs.getString("tag_name"), rs.getDouble("tag.length"), rs.getInt("tag.price"),rs.getInt("itemlisttag.quantity"));
                    Carport newCarport = new Carport(carportId, width,length,height, shed, spaer, rem,stolpe,tag);
                    carportList.add(newCarport);


                }



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carportList;
    }


}
