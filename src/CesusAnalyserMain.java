package com.java8.streams.census.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CesusAnalyserMain {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{

		File file = new File("resources\\cities_r2.csv");
		FileReader reader = new FileReader(file);
		BufferedReader breader = new BufferedReader(reader);
		List<CensusRecord> list = breader.lines().skip(1).map(a -> CSVDataParser.parseCensusRecord(a)).collect(Collectors.toList());

		file = new File("resources\\census\\state_region_mapping.csv");
		reader = new FileReader(file);
		breader = new BufferedReader(reader);
		List<StateRegion> stateRegionList = breader.lines().skip(1).map(a -> CSVDataParser.parseStateRegion(a)).collect(Collectors.toList());

		
		
		/*
		 //count number of districts in each state 
		  
		 Map<String, Long> map = list.stream().collect(Collectors.groupingBy(CensusRecord::getState_name, Collectors.counting()));
		
		 map.forEach((b,c)-> System.out.printf("%s %s \n", b, c));
		*/
		
		
		/*
		
		// display state wise population
		
		list.stream().collect(Collectors.groupingBy(CensusRecord::getState_name, Collectors.summingLong(a -> Long.parseLong(a.getPopulation_total())))).forEach((a,b) -> System.out.printf("%s %s \n",a,b));
		
		*/
		
		/*
		 // give top 3 populated districts of each state
		  
		 Map<String, Map<String, Long>> sortByPopCity =  list.stream().collect(Collectors.groupingBy(CensusRecord::getState_name, 
				Collectors.groupingBy(CensusRecord::getDist_code, 
						Collectors.summingLong(a -> Long.parseLong(a.getPopulation_total())))));
		
		sortByPopCity.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(a -> a.getValue().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(3).forEach(b -> System.out.println(a.getKey()+" "+b.getKey()+" "+b.getValue())));
		*/
		
		
		/*
		 // give most / top 5 cities by total population among all states
		  
		  list.stream().sorted((a,b) -> Long.compare(Long.parseLong(b.getPopulation_total()) , Long.parseLong(a.getPopulation_total()))).limit(5).forEach(a -> System.out.println(a.getName_of_city()+" "+a.getPopulation_total()));
		 */
		
		
		
		/*
		 4. give most / top 2 cities by total population for each state sort by state name in desc
		 
		list.stream().collect(Collectors.groupingBy(CensusRecord::getState_name, TreeMap::new, Collectors.toList())).forEach(
				(a,b) -> b.stream().sorted((c,d) -> 
						Long.compare(Long.parseLong(d.getPopulation_total()), Long.parseLong(c.getPopulation_total()))).limit(2).forEach(e -> System.out.println(e.getState_name()+" "+e.getName_of_city()+" "+e.getPopulation_total())));
	 
		*/
		
		/*
		 5. give most / top 2 districts by total population of each state order by state name in reverse
		  
		 list.stream().collect(Collectors.groupingBy(CensusRecord::getState_name, () -> new TreeMap<String, List<CensusRecord>>(Comparator.reverseOrder()), Collectors.toList())).forEach(
				(a,b) -> b.stream().sorted((c,d) -> 
						Long.compare(Long.parseLong(d.getPopulation_total()), Long.parseLong(c.getPopulation_total()))).limit(2).forEach(e -> System.out.println(e.getState_name()+" "+e.getName_of_city()+" "+e.getPopulation_total())));
		*/
		
		
		/*
		 6. give most / top 3 skewed city by gender population among all states ascending and descending
		 		 
		
		Comparator<CensusRecord> first = ((a,b) -> Double.compare(Double.parseDouble(a.population_female)/Double.parseDouble(a.population_total) , Double.parseDouble(b.population_female)/Double.parseDouble(b.population_total)));

		list.stream()
			.sorted(first)
			.limit(3)
			.forEach(a -> System.out.printf("\n %S Total=%S Female=%S Ratio=%f",a.getName_of_city(),a.getPopulation_total(),a.getPopulation_female(),Double.parseDouble(a.population_female)/Double.parseDouble(a.population_total)));
		
		System.out.println("\n\nin Reverse");
		list.stream()
		.sorted(first.reversed())
		.limit(3)
		.forEach(a -> System.out.printf("\n %S Total=%S Female=%S Ratio=%f",a.getName_of_city(),a.getPopulation_total(),a.getPopulation_female(),Double.parseDouble(a.population_female)/Double.parseDouble(a.population_total)));
	
		 
		 */
		
		/*
		 
		 7. give most / top 3 skewed district by gender population among all states (district codes can be replicated among states)
		 
		 Comparator<CensusRecord> c1 = ((b,a) -> Double.compare(Double.parseDouble(a.population_female)/Double.parseDouble(a.population_total) , Double.parseDouble(b.population_female)/Double.parseDouble(b.population_total))); 
		
		Map<String, List<CensusRecord>> sortByPopCity =list.stream()
		.collect(Collectors.groupingBy(CensusRecord::getDist_code)); 
				
		
		sortByPopCity.entrySet().stream().forEach(
				 b -> b.getValue().stream().sorted(c1).limit(3).forEach(
						 c -> System.out.printf("\n district=%S Total=%S Female=%S Ratio=%f",b.getKey(),c.getPopulation_total(),c.getPopulation_female(),Double.parseDouble(c.population_female)/Double.parseDouble(c.population_total)
						 )
				 )	
		);
		 */
		
		
		
		
		/*
		 8. give most / top 3 skewed state by gender population among all states
		 
		 
		 
		
		Comparator<Map.Entry<String, CensusRecord>> c3 = (b,a) -> Double.compare(1.0*b.getValue().population_female_long/b.getValue().population_total_long, 
																	1.0*a.getValue().population_female_long/a.getValue().population_total_long); 
		
		list.stream().collect(Collectors.toMap(
				CensusRecord::getState_name, Function.identity(), (c,d)-> 
				{
					CensusRecord c1 = new CensusRecord((CensusRecord)c);
					c1.population_total_long+=((CensusRecord)d).population_total_long; 
					c1.population_female_long+=((CensusRecord)d).population_female_long;
					return c1;
				}))
		.entrySet().stream().sorted(c3.reversed()).limit(10).forEach(
				c -> System.out.printf(
						"\n state=%S Total=%S Female=%S Ratio=%f",
						c.getValue().getState_name(),
						c.getValue().population_total_long, 
						c.getValue().population_female_long, 
						(1.0*c.getValue().population_female_long)/c.getValue().population_total_long)
				);
		
		*/
		
		/*
		 10. give top 3 skewed city by gender population for each state sort by state name
		 
		 
		 
		Comparator<CensusRecord> c3 = (b,a) -> Double.compare(1.0*b.population_female_long/b.population_total_long, 
				1.0*a.population_female_long/a.population_total_long); 
		list.stream().collect(Collectors.groupingBy(CensusRecord::getState_name ,() -> new TreeMap<String, List<CensusRecord>>() ,Collectors.toList()))
			.entrySet()
			.stream()
			.forEach(
					a -> a.getValue().stream().sorted(c3.reversed()).limit(3).forEach(
							c -> System.out.printf(
									"\n state=%S Total=%S Female=%S Ratio=%f",
									c.getState_name(),
									c.population_total_long, 
									c.population_female_long, 
									(1.0*c.population_female_long)/c.population_total_long)
					
					)
			);
			
		*/
		
		/*
		 
		 11. give most 5 literate cities among all states
		 
		Comparator<CensusRecord> c4 = (a,b) -> Double.compare(1.0*a.literates_total_long/a.population_total_long, 1.0*b.literates_total_long/b.population_total_long);
		
		list.stream().sorted(c4.reversed()).limit(5).forEach(
				a -> System.out.printf("\nState=%s City=%s Total=%s Literate=%s Ratio=%f", 
				a.state_name,
				a.name_of_city,
				a.population_total,
				a.literates_total,
				1.0*a.literates_total_long/a.population_total_long)
				);
		 */
		
		
		
		
		/*
		 
		 11. give most 50% literate cities among all states 
		
		 Comparator<CensusRecord> c4 = (a,b) -> Double.compare(1.0*a.literates_total_long/a.population_total_long, 1.0*b.literates_total_long/b.population_total_long);
		
		list.stream().sorted(c4.reversed()).limit(list.size()/2).forEach(
				a -> System.out.printf("\nState=%s City=%s Total=%s Literate=%s Ratio=%f", 
				a.state_name,
				a.name_of_city,
				a.population_total,
				a.literates_total,
				1.0*a.literates_total_long/a.population_total_long)
				);
		 */
		
		
		
		
		
		/*
		 
		 11. give most literate cities whose literacy rate is above 85% among all states
		 
		  Comparator<CensusRecord> c4 = (a,b) -> Double.compare(1.0*a.literates_total_long/a.population_total_long, 1.0*b.literates_total_long/b.population_total_long);
		Predicate<CensusRecord> p1 = (a) -> (1.0*a.literates_total_long/a.population_total_long) > 0.85;
		
		list.stream().sorted(c4.reversed()).filter(p1).forEach(
				a -> System.out.printf("\nState=%s City=%s Total=%s Literate=%s Ratio=%f", 
				a.state_name,
				a.name_of_city,
				a.population_total,
				a.literates_total,
				1.0*a.literates_total_long/a.population_total_long)
				);
		
		 */
		
		
		/*
		 12. give Top 5 literate district among all states
		 
		 BinaryOperator<CensusRecord> mergeFunction = (a,b) -> new CensusRecord((CensusRecord)a, (CensusRecord)b);
			
		Comparator<CensusRecord> c5 = (a,b) -> Double.compare(1.0*a.literates_total_long/a.population_total_long, 1.0*b.literates_total_long/b.population_total_long);
		
		list.stream()
		.collect(
				Collectors.toMap
				(
						CensusRecord::getDist_code, 
						Function.identity(), 
						mergeFunction						
				)
				)
		.values()
		.stream()
		.sorted(c5.reversed())
		.limit(5)
		.forEach(
				a -> System.out.printf("\nDistrict=%s Total=%s Literate=%s Ratio=%f", 
						a.getDist_code(),
						a.population_total_long,
						a.literates_total_long,
						1.0*a.literates_total_long/a.population_total_long)
				);
		
				;
		
		 
		 */
		
		/*
		 14. give top 5 literate state among all states whose literacy rate is above 85%
		
		  BinaryOperator<CensusRecord> mergeFunction = (a,b) -> new CensusRecord((CensusRecord)a, (CensusRecord)b);
		Comparator<CensusRecord> c6 = (a,b) -> Double.compare(1.0*a.literates_total_long/a.population_total_long, 1.0*b.literates_total_long/b.population_total_long);
		Predicate<CensusRecord> p2 = (a) -> (1.0*a.literates_total_long/a.population_total_long) > 0.85;
		
		list.stream()
		.collect(
				Collectors.toMap(
						CensusRecord::getState_name, 
						Function.identity(),
						mergeFunction
						))
		.values()
		.stream()
		.sorted(c6.reversed())
		.filter(p2)
		.limit(5)
		.forEach(
				a -> System.out.printf("\nDistrict=%s Total=%s Literate=%s Ratio=%f", 
						a.state_name,
						a.population_total_long,
						a.literates_total_long,
						1.0*a.literates_total_long/a.population_total_long)
				
				);
		
		 */
		
		
		
		/*
		 15. find out co-relation between population and literacy rate for each city for all states.
		 
		 
		 */
		
		/*
		 15. prove right/wrong that if percentage of female population ratio among total population is greater then, 
		 	 literacy rate of population is greater for cities.
		 
		 Approach-
		// calculate City wise female population percentage
		// calculate City wise Literacy rate percentage
		// Print the data as descending by female population and check if any out liar present for female population ratio to literacy ratio
		
 		Comparator<CensusRecord> c7 = (a,b) -> Double.compare(1.0*a.population_female_long/a.population_total_long, 1.0*b.population_female_long/b.population_total_long);
		Comparator<CensusRecord> c8 = (a,b) -> Double.compare(1.0*a.literates_total_long/a.population_total_long, 1.0*b.literates_total_long/b.population_total_long);
		
		list.stream().sorted(c7.reversed()).forEach(
				a -> System.out.printf("\nCity=%s FemaleRatio=%s LiteracyRatio=%s", 
						a.name_of_city,
						(1.0*a.population_female_long/a.population_total_long),
						(1.0*a.literates_total_long/a.population_total_long)
						)
				);
		

		 */
		
		
		
		/*
		 16. prove right/wrong that if female literacy rate is higher then percentage of 0-6 years population is less compared to lower female literacy rate cities.
		
		 Approach-
		 calculate female literacy rate among all population for each city
		 calculate 0-6 years population % amonf total population for each city
		 join above two data sets on city to find out combined result.
		
		 Comparator<CensusRecord> c9 = (a,b) -> Double.compare(1.0*a.literates_female_long/a.population_total_long, 1.0*b.literates_female_long/b.population_total_long);
		Comparator<CensusRecord> c10 = (a,b) -> Double.compare(1.0*a.population_total_0_6_long/a.population_total_long, 1.0*b.population_total_0_6_long/b.population_total_long);
		
		list.stream().sorted(c9.reversed()).limit(20).forEach(
				a -> System.out.printf("\nCity=%s FemaleLiterctRatio=%s 0-6PopulationRatio=%s", 
						a.name_of_city,
						(1.0*a.literates_female_long/a.population_total_long),
						(1.0*a.population_total_0_6_long/a.population_total_long)
						)
				);
		
		
		 */
		
		/*
		
			17. Join State-Region fle with CensusRecords and find out male-female ratio per region
			
			here state-region file is small so create map of it and then use it as partitioner 
		*/
		
		
		final Map<String, String> stateRegionMap = stateRegionList.stream().collect(Collectors.toMap(StateRegion::getState, StateRegion::getRegion));
		
		BinaryOperator<CensusRecord> mergeFunc1 = (a,b) -> new CensusRecord(a,b);
		
		BiFunction<CensusRecord, CensusRecord, CensusRecord> mapmerge = (a,b) -> {
			if(a!=null && b!=null) return new CensusRecord(a,b);
			return a;
			};
		
		
		Map<String, CensusRecord> regionMap = new HashMap<>();
		
		list.stream().collect(Collectors.toMap(
								CensusRecord::getState_name, 
								Function.identity(), 
								mergeFunc1 
								))
		.forEach( (a,b) -> {
			if(stateRegionMap.get(a) == null)
				System.out.println(a);
			regionMap.put(stateRegionMap.get(a), new CensusRecord(b, regionMap.get(stateRegionMap.get(a))));
		} );
		
		regionMap.forEach(
				(a,b) -> {
					
					System.out.printf("\n Region=%s TotalPopulation=%d MalePopulation=%d FemalePopulation=%d Ratio=%f",
							a,
							b.population_total_long,
							b.population_male_long,
							b.population_female_long,
							(1.0*b.population_female_long/b.population_male_long)*1000);
					
				});
		
		
		breader.close();
		reader.close();
		
	}
	
	
	

}
