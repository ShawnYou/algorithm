package com.ysl;

import com.ysl.tw.graph.RouteNetwork;
import com.ysl.tw.graph.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmApplicationTests {

	private static RouteNetwork routeNetwork = new RouteNetwork();
	private Station A = new Station("A");
	private Station B = new Station("B");
	private Station C = new Station("C");
	private Station D = new Station("D");
	private Station E = new Station("E");
	private Station F = new Station("F");

	/**
	 *  test data: A,B,C
	 */
	@Test
	public void caculDistanceTest1(){
		Integer distance = routeNetwork.caculateDistance(A,B,C);
		Assert.assertEquals(0,(Object)distance);
	}

	/**
	 * test data: A,D
	 */
	@Test
	public void caculDistanceTest2(){
		Integer distance = routeNetwork.caculateDistance(A,D);
		Assert.assertEquals(0,(Object)distance);
	}

	/**
	 * test data: A,D,C
	 */
	@Test
	public void caculDistanceTest3(){
		Integer distance = routeNetwork.caculateDistance(A,D,C);
		Assert.assertEquals(0,(Object)distance);
	}

	/**
	 * test data: A,E,B,C,D
	 */
	@Test
	public void caculDistanceTest4(){
		Integer distance = routeNetwork.caculateDistance(A,E,B,C,D);
		Assert.assertEquals(0,(Object)distance);
	}

	/**
	 * test data: A,E,D
	 */
	@Test
	public void caculDistanceTest5(){
		Integer distance = routeNetwork.caculateDistance(A,E,D);
		Assert.assertEquals(1,(Object)distance);
	}

	/**
	 *  test data:
	 *   The number of trips starting at C and ending at C with a maximum of 3 stops
	 */
	@Test
	public void howTripWithMaxStopTest(){
		Integer tripCount = routeNetwork.howTripWithMaxStop(C,C,3);
		Assert.assertEquals(0,(Object)tripCount);
	}

	/**
	 *  test data:
	 *   The number of trips starting at Aand ending at C with exactly 4 stops
	 */
	@Test
	public void howTripWithExactStopsTest(){
		Integer tripCount = routeNetwork.howTripWithExactStop(A,C,4);
		Assert.assertEquals(1,(Object)tripCount);
	}

	/**
	 *  test data:
	 *   The number of trips starting at Aand ending at C with exactly 4 stops
	 */
	@Test
	public void getShortestLenWithStopsTest1(){
		Integer distance = routeNetwork.getShortestLenWithStops(A,C);
		Assert.assertEquals(0,(Object)distance);
	}

	/**
	 *  test data:
	 *   The number of trips starting at Aand ending at C with exactly 4 stops
	 */
	@Test
	public void getShortestLenWithStopsTest2(){
		Integer distance = routeNetwork.getShortestLenWithStops(B,B);
		Assert.assertEquals(0,(Object)distance);
	}

	@Test
	public void getTripQtyWithLimitDisTest(){
		Integer count = routeNetwork.getTripQtyWithLimitDis(C,C,30);
		Assert.assertEquals(0,(Object)count);
	}

}
