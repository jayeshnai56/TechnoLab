package com.lattitudetech.model;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class User implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("company")
    @Expose
    private Company company;
    public final static Creator<User> CREATOR = new Creator<User>() {

        public User createFromParcel(android.os.Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    };

    protected User(android.os.Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((Address) in.readValue((Address.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.website = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((Company) in.readValue((Company.class.getClassLoader())));
    }

    public User() {
    }

    public User(Integer id, String name, String username, String email, Address address, String phone, String website, Company company) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("username");
        sb.append('=');
        sb.append(((this.username == null) ? "<null>" : this.username));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null) ? "<null>" : this.email));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null) ? "<null>" : this.address));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null) ? "<null>" : this.phone));
        sb.append(',');
        sb.append("website");
        sb.append('=');
        sb.append(((this.website == null) ? "<null>" : this.website));
        sb.append(',');
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null) ? "<null>" : this.company));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.website == null) ? 0 : this.website.hashCode()));
        result = ((result * 31) + ((this.address == null) ? 0 : this.address.hashCode()));
        result = ((result * 31) + ((this.phone == null) ? 0 : this.phone.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.company == null) ? 0 : this.company.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.email == null) ? 0 : this.email.hashCode()));
        result = ((result * 31) + ((this.username == null) ? 0 : this.username.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return (((((((((this.website == rhs.website) || ((this.website != null) && this.website.equals(rhs.website))) && ((this.address == rhs.address) || ((this.address != null) && this.address.equals(rhs.address)))) && ((this.phone == rhs.phone) || ((this.phone != null) && this.phone.equals(rhs.phone)))) && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))) && ((this.company == rhs.company) || ((this.company != null) && this.company.equals(rhs.company)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.email == rhs.email) || ((this.email != null) && this.email.equals(rhs.email)))) && ((this.username == rhs.username) || ((this.username != null) && this.username.equals(rhs.username))));
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(username);
        dest.writeValue(email);
        dest.writeValue(address);
        dest.writeValue(phone);
        dest.writeValue(website);
        dest.writeValue(company);
    }

    public int describeContents() {
        return 0;
    }

    public static class Address implements Parcelable {

        @SerializedName("street")
        @Expose
        private String street;
        @SerializedName("suite")
        @Expose
        private String suite;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("zipcode")
        @Expose
        private String zipcode;
        @SerializedName("geo")
        @Expose
        private Geo geo;
        public final static Creator<Address> CREATOR = new Creator<Address>() {

            public Address createFromParcel(android.os.Parcel in) {
                return new Address(in);
            }

            public Address[] newArray(int size) {
                return (new Address[size]);
            }

        };

        protected Address(android.os.Parcel in) {
            this.street = ((String) in.readValue((String.class.getClassLoader())));
            this.suite = ((String) in.readValue((String.class.getClassLoader())));
            this.city = ((String) in.readValue((String.class.getClassLoader())));
            this.zipcode = ((String) in.readValue((String.class.getClassLoader())));
            this.geo = ((Geo) in.readValue((Geo.class.getClassLoader())));
        }

        public Address() {
        }

        public Address(String street, String suite, String city, String zipcode, Geo geo) {
            super();
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Address.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("street");
            sb.append('=');
            sb.append(((this.street == null) ? "<null>" : this.street));
            sb.append(',');
            sb.append("suite");
            sb.append('=');
            sb.append(((this.suite == null) ? "<null>" : this.suite));
            sb.append(',');
            sb.append("city");
            sb.append('=');
            sb.append(((this.city == null) ? "<null>" : this.city));
            sb.append(',');
            sb.append("zipcode");
            sb.append('=');
            sb.append(((this.zipcode == null) ? "<null>" : this.zipcode));
            sb.append(',');
            sb.append("geo");
            sb.append('=');
            sb.append(((this.geo == null) ? "<null>" : this.geo));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = ((result * 31) + ((this.zipcode == null) ? 0 : this.zipcode.hashCode()));
            result = ((result * 31) + ((this.geo == null) ? 0 : this.geo.hashCode()));
            result = ((result * 31) + ((this.suite == null) ? 0 : this.suite.hashCode()));
            result = ((result * 31) + ((this.city == null) ? 0 : this.city.hashCode()));
            result = ((result * 31) + ((this.street == null) ? 0 : this.street.hashCode()));
            return result;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Address)) {
                return false;
            }
            Address rhs = ((Address) other);
            return (((((Objects.equals(this.zipcode, rhs.zipcode))
                    && (Objects.equals(this.geo, rhs.geo)))
                    && (Objects.equals(this.suite, rhs.suite)))
                    && (Objects.equals(this.city, rhs.city)))
                    && (Objects.equals(this.street, rhs.street)));
        }

        public void writeToParcel(android.os.Parcel dest, int flags) {
            dest.writeValue(street);
            dest.writeValue(suite);
            dest.writeValue(city);
            dest.writeValue(zipcode);
            dest.writeValue(geo);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Company implements Parcelable {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("catchPhrase")
        @Expose
        private String catchPhrase;
        @SerializedName("bs")
        @Expose
        private String bs;
        public final static Creator<Company> CREATOR = new Creator<Company>() {

            public Company createFromParcel(android.os.Parcel in) {
                return new Company(in);
            }

            public Company[] newArray(int size) {
                return (new Company[size]);
            }

        };

        protected Company(android.os.Parcel in) {
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.catchPhrase = ((String) in.readValue((String.class.getClassLoader())));
            this.bs = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Company() {
        }

        public Company(String name, String catchPhrase, String bs) {
            super();
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Company.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("name");
            sb.append('=');
            sb.append(((this.name == null) ? "<null>" : this.name));
            sb.append(',');
            sb.append("catchPhrase");
            sb.append('=');
            sb.append(((this.catchPhrase == null) ? "<null>" : this.catchPhrase));
            sb.append(',');
            sb.append("bs");
            sb.append('=');
            sb.append(((this.bs == null) ? "<null>" : this.bs));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
            result = ((result * 31) + ((this.bs == null) ? 0 : this.bs.hashCode()));
            result = ((result * 31) + ((this.catchPhrase == null) ? 0 : this.catchPhrase.hashCode()));
            return result;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof Company)) {
                return false;
            }
            Company rhs = ((Company) other);
            return (((Objects.equals(this.name, rhs.name))
                    && (Objects.equals(this.bs, rhs.bs)))
                    && (Objects.equals(this.catchPhrase, rhs.catchPhrase)));
        }

        public void writeToParcel(android.os.Parcel dest, int flags) {
            dest.writeValue(name);
            dest.writeValue(catchPhrase);
            dest.writeValue(bs);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Geo implements Parcelable {

        @SerializedName("lat")
        @Expose
        private String lat;
        @SerializedName("lng")
        @Expose
        private String lng;
        public final static Creator<Geo> CREATOR = new Creator<Geo>() {

            public Geo createFromParcel(android.os.Parcel in) {
                return new Geo(in);
            }

            public Geo[] newArray(int size) {
                return (new Geo[size]);
            }

        };

        protected Geo(android.os.Parcel in) {
            this.lat = ((String) in.readValue((String.class.getClassLoader())));
            this.lng = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Geo() {
        }

        public Geo(String lat, String lng) {
            super();
            this.lat = lat;
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Geo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("lat");
            sb.append('=');
            sb.append(((this.lat == null) ? "<null>" : this.lat));
            sb.append(',');
            sb.append("lng");
            sb.append('=');
            sb.append(((this.lng == null) ? "<null>" : this.lng));
            sb.append(',');
            if (sb.charAt((sb.length() - 1)) == ',') {
                sb.setCharAt((sb.length() - 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = ((result * 31) + ((this.lng == null) ? 0 : this.lng.hashCode()));
            result = ((result * 31) + ((this.lat == null) ? 0 : this.lat.hashCode()));
            return result;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof Geo) == false) {
                return false;
            }
            Geo rhs = ((Geo) other);
            return ((Objects.equals(this.lng, rhs.lng)) && (Objects.equals(this.lat, rhs.lat)));
        }

        public void writeToParcel(android.os.Parcel dest, int flags) {
            dest.writeValue(lat);
            dest.writeValue(lng);
        }

        public int describeContents() {
            return 0;
        }

    }

}