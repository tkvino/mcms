package za.co.telkom.managercustomerms;

import za.co.telkom.managercustomerms.service.Fruit;
import za.co.telkom.managercustomerms.service.FruitRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerCustomerMsApplicationTests {

	@Autowired
	private FruitRepository IFruitRepository;

	@Before
	public void beforeTest() {
	}

	@Test
	public void testGetAll() {
		assertTrue(IFruitRepository.findAll().spliterator().getExactSizeIfKnown()==3);
	}

	@Test
	public void getOne() {
		assertTrue(IFruitRepository.findOne(1)!=null);
	}

	@Test
	public void updateAFruit() {
		Fruit apple = IFruitRepository.findOne(2);
		assertTrue(apple!=null);
		assertTrue(apple.getName().equals("Apple"));

		apple.setName("Green Apple");
		IFruitRepository.save(apple);

		assertTrue(IFruitRepository.findOne(2).getName().equals("Green Apple"));
	}

	@Test
	public void createAndDeleteAFruit() {
		int orangeId = IFruitRepository.save(new Fruit("Orange")).getId();
		Fruit orange = IFruitRepository.findOne(orangeId);
		assertTrue(orange!=null);
		IFruitRepository.delete(orange);
		assertTrue(IFruitRepository.findOne(orangeId)==null);
	}

	@Test
	public void getWrongId() {
		assertTrue(IFruitRepository.findOne(9999)==null);
	}
}
