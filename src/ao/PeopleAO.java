package ao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.zkoss.zul.ListModelList;

import biz.Person;

public class PeopleAO implements AO<Person>{
	private static PeopleAO uniqueInstance;
	private List<Person> peopleList;

	public static PeopleAO getUniqueInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new PeopleAO();
		}
		return uniqueInstance;
	}
	private PeopleAO() {
		super();
		peopleList=new ArrayList<>();
		peopleList.add(Person.createPerson("jken","johnkennedy@unitedstates.com","John","Fitzgerald","Kennedy","´1917-05-29"));
		peopleList.add(Person.createPerson("airness","mj@chicagobulls.com","Michael","Jeffrey","Jordan","1963-02-17"));
		peopleList.add(Person.createPerson("mms","mms@gouvernememt.be","Marie","Martine","Schyns","1977-05-19"));
		peopleList.add(Person.createPerson("aretha","arethafranklin","Aretha","Louise","Franklin","1942-03-25"));
		peopleList.add(Person.createPerson("waltdisney","disney@cartoonmakers.com","Walter","Elias","Disney","1901-12-05"));
	}

	@Override
	public List<Person> fetchAll() {
		// TODO Auto-generated method stub
		return peopleList;
	}

	@Override
	public List<Person> search(Map<String, Object> criteria) {
		// TODO Auto-generated method stub
		List<Person> newList=new ArrayList<Person>();
		for(Person p:peopleList) {
			boolean toAdd=true;
			for(Map.Entry<String, Object> entry:criteria.entrySet()) {
				Object o=entry.getValue();
				switch(entry.getKey()) {
					case "userName":
						if(!p.getUserName().equals((String)o)) {
							toAdd=false;
						}
					break;
					case "email":
						if(!p.getEmail().equals((String)o)) {
							toAdd=false;
						}
					break;
					case "firstName":
						if(!p.getFirstName().equals((String)o)) {
							toAdd=false;
						}
					break;
					case "middleName":
						if(!p.getMiddleName().equals((String)o)) {
							toAdd=false;
						}
					break;
					case "lastName":
						if(!p.getLastName().equals((String)o)) {
							toAdd=false;
						}
					break;
					case "birthDate":
						if(!p.getBirthDate().equals((String)o)) {
							toAdd=false;
						}
					break;
				}
			}
			if(toAdd) {
				newList.add(p);
			}
		}
		return newList;
	}

	@Override
	public boolean update(Person t) {
		// TODO Auto-generated method stub
		for(Person p:peopleList) {
			if(p.getEmail().equals(t.getEmail())) {
				p.setFirstName(t.getFirstName());
				p.setMiddleName(t.getMiddleName());
				p.setLastName(t.getLastName());
				p.setBirthDate(t.getBirthDate());
				break;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Person t) {
		// TODO Auto-generated method stub
		return false;
	}
	public ListModelList<Person> getModel() {
		// TODO Auto-generated method stub
		return new ListModelList<>(peopleList,true);
	}
}
