package notebook.model.Notebook.Recording;

import notebook.model.Notebook.Notebook.NotebookItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Recording implements Serializable, Comparable<Recording>, NotebookItem<String> {
    private int id;
    private String name;
    private LocalDate data;
    private Calendar dataMeeting;
    private List<String> places;
    private List<String> myCase;
    private List<String> people;
    private String addNewInformation;

    private int day;

    public Recording(int id, String name, String home, String street, String city, LocalDate data, Calendar dataMeeting,
                     String myCollague, String job, String addNewInformation, int day) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.dataMeeting = dataMeeting;
        this.day = day;
        places = new ArrayList<>();
        if (home != null) {
            System.out.println(home);
            places.add(home);
        }
        if (city != null) {
            places.add(city);
        }
        if (street != null) {
            places.add(street);
        }
        myCase = new ArrayList<>();
        if (job != null) {
            myCase.add(job);
        }
        people = new ArrayList<>();
        if (myCollague != null) {
            people.add(myCollague);
        }
        this.addNewInformation = addNewInformation;
    }


    public boolean addPeople(String peoples) {
        if (!people.contains(peoples)) {
            people.add(peoples);
            return true;
        }
        return false;
    }

    public boolean addPlace(String place) {
        if (!places.contains(place)) {
            places.add(place);
            return true;
        }
        return false;
    }


    public boolean addCase(String myCases) {
        if (!myCase.contains(myCases)) {
            myCase.add(myCases);
            return true;
        }
        return false;
    }

    public int getDay() {
        return day;
    }

    public void setDay() {
        this.day = day;
    }

    public String getHome() {
        String home = places.get(0);
        return home;
    }

    public String getStreet() {
        String street = places.get(2);
        return street;
    }

    public String getCity() {
        String city = places.get(1);
        return city;
    }

    public String getMeeting() {
        for (String meeting : myCase)
            return meeting;
        return null;
    }

    public String getJob() {
        for (String job : myCase)
            return job;
        return null;
    }

    public String getMyFriend() {
        for (String friend : people)
            return friend;
        return null;
    }

    public String getMyCollague() {
        for (String collague : people)
            return collague;
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Calendar getDataMeeting() {
        return dataMeeting;
    }

    public void setDataMeeting(Calendar dataMeeting) {
        this.dataMeeting = dataMeeting;
    }

    public List<String> getPlace() {
        return places;
    }

    public List<String> getMyCase() {
        return myCase;
    }

    public List<String> getPeople() {
        return people;
    }

    public String getAddNewInformation() {
        return addNewInformation;
    }

    public void setAddInformation(String addNewInformation) {
        this.addNewInformation = addNewInformation;
    }

    @Override
    public String toString() {
        return getInfoJob();
    }


    public String getInfoJob() {
        StringBuilder sb = new StringBuilder();
        sb.append("id");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", data: ");
        sb.append(data);
        sb.append(", data meeting: ");
        sb.append(dataMeeting());
        sb.append(getHomeInfo());
        sb.append(", ");
        sb.append(getStreetInfo());
        sb.append(", ");
        sb.append(getCityInfo());
        sb.append(", ");
        sb.append(getJobInfo());
        sb.append(", info : ");
        sb.append(addNewInformation);
        sb.append(", day week: ");
        sb.append(day);
        return sb.toString();
    }

    public Date dataMeeting() {
        Calendar dataMeeting = getDataMeeting();
        return dataMeeting.getTime();
    }

    public String getHomeInfo() {
        String result = " Home: ";
        String home = getHome();
        if (home != null) {
            result += home;
        } else {
            result += "unknow";
        }
        return result;
    }

    public String getStreetInfo() {
        String result = " City: ";
        String street = getStreet();
        if (street != null) {
            result += street;
        } else {
            result += "unknow";
        }
        return result;
    }

    public String getCityInfo() {
        String result = " City: ";
        String city = getCity();
        if (city != null) {
            result += city;
        } else {
            result += "unknow";
        }
        return result;
    }


    public String getJobInfo() {
        String result = " Case: ";
        String job = getJob();
        if (job != null) {
            result += job;
        } else {
            result += "unknow";
        }
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Recording)) {
            return false;
        }
        Recording recording = (Recording) obj;
        return recording.getId() == getId();
    }

    @Override
    public int compareTo(Recording o) {
        return name.compareTo(o.name);
    }

}
