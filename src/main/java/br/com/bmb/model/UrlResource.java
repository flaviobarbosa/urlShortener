package br.com.bmb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
	@NamedQuery(name = UrlResource.FIND_BY_ALIAS, query = "Select u from UrlResource u where u.alias = :alias"),
	@NamedQuery(name = UrlResource.FIND_ORDERED_BY_REQUESTS, query = "Select u From UrlResource u ORDER BY u.statistics.numberOfRequests DESC")
})
public class UrlResource {

	public static final String FIND_BY_ALIAS = "br.com.bmb.model.UrlResource#findByAlias";
	public static final String FIND_ORDERED_BY_REQUESTS = "br.com.bmb.model.UrlResource#findTopTen";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String alias;
	
	private String shortUrl;
	
	private String longUrl;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Statistic statistics;
	
	public UrlResource() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public Statistic getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistic statistics) {
		this.statistics = statistics;
	}

	@Override
	public String toString() {
		return "UrlResource [id=" + id + ", alias=" + alias + ", shortUrl=" + shortUrl + ", longUrl=" + longUrl
				+ ", statistics=" + statistics + "]";
	}
}
