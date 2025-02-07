package com.java8.streams.census.src;

public class CensusRecord {
	
	public String name_of_city;
	public String state_code;
	public String state_name;
	public String dist_code;
	public String population_total;
	public long population_total_long;
	public String population_male;
	public long population_male_long;
	public String population_female;
	public long population_female_long;
	public String population_total_0_6;
	public long population_total_0_6_long;
	public String population_male_0_6;
	public long population_male_0_6_long;
	public String population_female_0_6;
	public long population_female_0_6_long;
	public String literates_total;
	public long literates_total_long;
	public String literates_male;
	public long literates_male_long;
	public String literates_female;
	public long literates_female_long;
	public String sex_ratio;
	public long sex_ratio_long;
	public String child_sex_ratio;
	public long child_sex_ratio_long;
	public String effective_literacy_rate_total;
	public long effective_literacy_rate_total_long;
	public String effective_literacy_rate_male;
	public long effective_literacy_rate_male_long;
	public String effective_literacy_rate_female;
	public long effective_literacy_rate_female_long;
	public String location;
	public String total_graduates;
	public long total_graduates_long;
	public String male_graduates;
	public long male_graduates_long;
	public String female_graduates;
	public long female_graduates_long;
	
	public CensusRecord(){
		super();
	}
	
	public CensusRecord( CensusRecord a) {
		super();
		this.name_of_city = a.name_of_city;
		this.state_code = a.state_code;
		this.state_name = a.state_name;
		this.dist_code = a.dist_code;
		this.population_total = a.population_total;
		this.population_total_long=a.population_total_long;
		this.population_male = a.population_male;
		this.population_female = a.population_female;
		this.population_female_long=a.population_female_long;
		this.population_total_0_6 = a.population_total_0_6;
		this.population_male_0_6 = a.population_male_0_6;
		this.population_female_0_6 = a.population_female_0_6;
		this.literates_total = a.literates_total;
		this.literates_total_long = a.literates_total_long;
		this.literates_male = a.literates_male;
		this.literates_male_long=a.literates_male_long;
		this.literates_female = a.literates_female;
		this.literates_female_long=a.literates_female_long;
		this.sex_ratio = a.sex_ratio;
		this.child_sex_ratio = a.child_sex_ratio;
		this.effective_literacy_rate_total = a.effective_literacy_rate_total;
		this.effective_literacy_rate_male = a.effective_literacy_rate_male;
		this.effective_literacy_rate_female = a.effective_literacy_rate_female;
		this.location = a.location;
		this.total_graduates = a.total_graduates;
		this.male_graduates = a.male_graduates;
		this.female_graduates = a.female_graduates;
		
	}
	
	public CensusRecord( CensusRecord a, CensusRecord b) {
		if(a!=null && b !=null){
			this.name_of_city = a.name_of_city;
			this.state_code = a.state_code;
			this.state_name = a.state_name;
			this.dist_code = a.dist_code;
			this.population_total = a.population_total;
			this.population_total_long=a.population_total_long+b.population_total_long;
			this.population_male = a.population_male;
			this.population_male_long = a.population_male_long+b.population_male_long;
			this.population_female = a.population_female;
			this.population_female_long=a.population_female_long+b.population_female_long;
			this.population_total_0_6 = a.population_total_0_6;
			this.population_total_0_6_long = a.population_total_0_6_long+b.population_total_0_6_long;
			this.population_male_0_6 = a.population_male_0_6;
			this.population_male_0_6_long = a.population_male_0_6_long+b.population_male_0_6_long;
			this.population_female_0_6 = a.population_female_0_6;
			this.population_female_0_6_long = a.population_female_0_6_long+b.population_female_0_6_long;
			this.literates_total = a.literates_total;
			this.literates_total_long = a.literates_total_long+b.literates_total_long;
			this.literates_male = a.literates_male;
			this.literates_male_long=a.literates_male_long+b.literates_male_long;
			this.literates_female = a.literates_female;
			this.literates_female_long=a.literates_female_long+b.literates_female_long;
			this.sex_ratio = a.sex_ratio;
			this.sex_ratio_long = a.sex_ratio_long+b.sex_ratio_long;
			this.child_sex_ratio = a.child_sex_ratio;
			this.child_sex_ratio_long = a.child_sex_ratio_long+b.child_sex_ratio_long;
			this.effective_literacy_rate_total = a.effective_literacy_rate_total;
			this.effective_literacy_rate_total_long = a.effective_literacy_rate_total_long+b.effective_literacy_rate_total_long;
			this.effective_literacy_rate_male = a.effective_literacy_rate_male;
			this.effective_literacy_rate_male_long = a.effective_literacy_rate_male_long+b.effective_literacy_rate_male_long;
			this.effective_literacy_rate_female = a.effective_literacy_rate_female;
			this.effective_literacy_rate_female_long = a.effective_literacy_rate_female_long+b.effective_literacy_rate_female_long;
			this.location = a.location;
			this.total_graduates = a.total_graduates;
			this.total_graduates_long = a.total_graduates_long+b.total_graduates_long;
			this.male_graduates = a.male_graduates;
			this.male_graduates_long = a.male_graduates_long+b.male_graduates_long;
			this.female_graduates = a.female_graduates;
			this.female_graduates_long = a.female_graduates_long+b.female_graduates_long;
		}
		
	}
	
	
	
	
	public void setName_of_city(String name_of_city) {
		this.name_of_city = name_of_city;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public void setDist_code(String dist_code) {
		this.dist_code = dist_code;
	}

	public void setPopulation_total(String population_total) {
		this.population_total = population_total;
	}

	public void setPopulation_male(String population_male) {
		this.population_male = population_male;
	}

	public void setPopulation_female(String population_female) {
		this.population_female = population_female;
	}

	public void setPopulation_total_0_6(String population_total_0_6) {
		this.population_total_0_6 = population_total_0_6;
	}

	public void setPopulation_male_0_6(String population_male_0_6) {
		this.population_male_0_6 = population_male_0_6;
	}

	public void setPopulation_female_0_6(String population_female_0_6) {
		this.population_female_0_6 = population_female_0_6;
	}

	public void setLiterates_total(String literates_total) {
		this.literates_total = literates_total;
	}

	public void setLiterates_male(String literates_male) {
		this.literates_male = literates_male;
	}

	public void setLiterates_female(String literates_female) {
		this.literates_female = literates_female;
	}

	public void setSex_ratio(String sex_ratio) {
		this.sex_ratio = sex_ratio;
	}

	public void setChild_sex_ratio(String child_sex_ratio) {
		this.child_sex_ratio = child_sex_ratio;
	}

	public void setEffective_literacy_rate_total(String effective_literacy_rate_total) {
		this.effective_literacy_rate_total = effective_literacy_rate_total;
	}

	public void setEffective_literacy_rate_male(String effective_literacy_rate_male) {
		this.effective_literacy_rate_male = effective_literacy_rate_male;
	}

	public void setEffective_literacy_rate_female(String effective_literacy_rate_female) {
		this.effective_literacy_rate_female = effective_literacy_rate_female;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTotal_graduates(String total_graduates) {
		this.total_graduates = total_graduates;
	}

	public void setMale_graduates(String male_graduates) {
		this.male_graduates = male_graduates;
	}

	public void setFemale_graduates(String female_graduates) {
		this.female_graduates = female_graduates;
	}

	public String getName_of_city() {
		return name_of_city;
	}
	public String getState_code() {
		return state_code;
	}
	public String getState_name() {
		return state_name;
	}
	public String getDist_code() {
		return dist_code;
	}
	public String getPopulation_total() {
		return population_total;
	}
	public String getPopulation_male() {
		return population_male;
	}
	public String getPopulation_female() {
		return population_female;
	}
	public String getPopulation_total_0_6() {
		return population_total_0_6;
	}
	public String getPopulation_male_0_6() {
		return population_male_0_6;
	}
	public String getPopulation_female_0_6() {
		return population_female_0_6;
	}
	public String getLiterates_total() {
		return literates_total;
	}
	public String getLiterates_male() {
		return literates_male;
	}
	public String getLiterates_female() {
		return literates_female;
	}
	public String getSex_ratio() {
		return sex_ratio;
	}
	public String getChild_sex_ratio() {
		return child_sex_ratio;
	}
	public String getEffective_literacy_rate_total() {
		return effective_literacy_rate_total;
	}
	public String getEffective_literacy_rate_male() {
		return effective_literacy_rate_male;
	}
	public String getEffective_literacy_rate_female() {
		return effective_literacy_rate_female;
	}
	public String getLocation() {
		return location;
	}
	public String getTotal_graduates() {
		return total_graduates;
	}
	public String getMale_graduates() {
		return male_graduates;
	}
	public String getFemale_graduates() {
		return female_graduates;
	}

}
