package com.excellence.springbootcrudoperationwithsecurity.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDate duedate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskStatus status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User assignedUser;
	
	@ElementCollection
	@CollectionTable(name="task_tags",joinColumns = @JoinColumn(name="task_id"))
	@Column(name="tag")
	private Set<String> tags;
	

}
