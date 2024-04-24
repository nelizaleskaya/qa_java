import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline; //создание Mock класса Feline

    @Test //проверка, что метод getSound() возвращает "Мяу"
    public void testGetSoundCat() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test //проверка, что метод eatMeat() вызывается 2 раза
    public void testGetFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        cat.getFood();
        Mockito.verify(feline, Mockito.times(2)).eatMeat();
    }

    @Test //проверяю, что метод getFood возвращает список еды для кошки
    public void catGetFoodPredatorList() throws Exception {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
