
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import modelsPerson.PersonModels;
import modelsPerson.Root;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.RestGet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestPerson {
    static String url = "https://rickandmortyapi.com/api/character";
    static List<String> listUrls = new ArrayList<>();
    static ObjectMapper om;
    @BeforeClass
    public static void startData() throws JsonProcessingException {
        listUrls.add(url);
        om= new ObjectMapper();
        while (true) {
            Root root = om.readValue(RestGet.GetExchange(url), Root.class);
            if (!Objects.equals(root.info.next, null)) {
                listUrls.add(root.info.next);
                url = root.info.next;
            } else {
                break;
            }
        }
    }

    @Test
    public void test() throws JsonProcessingException {
        for (String l:listUrls){
            Root model=om.readValue(RestGet.GetExchange(l), Root.class);
            for(PersonModels r:model.results){
                System.out.println("------------------------------");
                System.out.println(r);
            }
        }
    }
}

