
create table address
(
	id				int4	generated always as identity primary key,
	city			varchar(50) not null,
	street			varchar(50) not null,
	building_number	varchar(10) not null
	
);


create table school 
(
	id 			int4 generated always as identity primary key,
	name		varchar(250) not null,
	address_id	int4 not null,
	
	constraint fk__school__address__id foreign key (address_id) references address (id)
);

create table parent 
(
	id 			int4 generated always as identity primary key,
	first_name	varchar(30) not null,
	last_name	varchar(30) not null
);

create table teacher
(
	id			int4 generated always as identity primary key,
	first_name	varchar(30) not null,
	last_name	varchar(30) not null
);

create table "group"
(
	id 			int4 generated always as identity primary key,
	name		varchar(10) not null,
	school_id	int4 not null,
	
	constraint uq__group__name unique (name),
	constraint fk__group__school__id foreign key (school_id) references school (id)
);

create table group_room
(
	id			int4 generated always as identity primary key,
	name		varchar(10) not null,
	school_id	int4 not null,
	
	constraint uq__group_room__name unique (name),
	constraint fk__group_room__school__id foreign key (school_id) references school (id)
);

create table schedule
(
	id			int4 generated always as identity primary key,
	start_date	timestamp with time zone not null,
	end_date	timestamp with time zone not null,
	school_id	int4 not null,
	
	constraint fk__schedule__school__id foreign key (school_id) references school (id)
);

create table lesson
(
	id				int4 generated always as identity primary key,
	name			varchar(20) not null,
	group_room_id	int4 not null,
	
	constraint fk__lesson__group_room__id foreign key (group_room_id) references "group" (id)
);

create table student
(
	id				int4 generated always as identity primary key,
	first_name		varchar(30) not null,
	last_name		varchar(30) not null,
	parent_id		int4 not null,
	school_id		int4 not null,
	
	constraint fk__student__parent__id foreign key (parent_id) references parent (id),
	constraint fk__student__group__id foreign key (school_id) references school (id)
);

create table attend
(
	id 			int4 generated always as identity primary key,
	visited 	boolean not null,
	student_id	int4 not null,
	
	constraint fk__attend__student__id foreign key (student_id) references student (id)
);

create table subject
(
	id 			int4 generated always as identity primary key,
	name		varchar (30) not null,
	school_id	int4 not null,
	
	constraint fk__subject__school__id foreign key (school_id) references school (id)
);

create table assessment
(
	id 			int8 generated always as identity primary key,
	value		int2 not null check (value > 0 and value < 11),
	student_id	int4 not null,
	
	constraint fk__assessment__student__id foreign key (student_id) references student (id)
);

create table group_assessment
(
	id 				int4 generated always as identity primary key,
	assessment_id	int8 not null,
	group_id		int4 not null,
	
	constraint fk__group_assessment__assessment__id foreign key (assessment_id) references assessment (id),
	constraint fk__group_assessment__group__id foreign key (group_id) references "group" (id)
);

create table group_teacher
(
	id 				int4 generated always as identity primary key,
	teacher_id		int4 not null,
	group_id		int4 not null,
	
	constraint fk__group_teacher__teacher__id foreign key (teacher_id) references teacher (id),
	constraint fk__group_teacher__group__id foreign key (group_id) references "group" (id)
);

create table group_parent
(
	id 				int4 generated always as identity primary key,
	parent_id		int4 not null,
	group_id		int4 not null,
	
	constraint fk__group_parent__parent__id foreign key (parent_id) references parent (id),
	constraint fk__group_parent__group__id foreign key (group_id) references "group" (id)
);

create table group_subject
(
	id 				int4 generated always as identity primary key,
	subject_id		int4 not null,
	group_id		int4 not null,
	
	constraint fk__group_subject__subject__id foreign key (subject_id) references subject (id),
	constraint fk__group_subject__group__id foreign key (group_id) references "group" (id)
);

create table group_group_room
(
	id 				int4 generated always as identity primary key,
	group_room_id	int4 not null,
	group_id		int4 not null,
	
	constraint fk__group_group_room__group_room__id foreign key (group_room_id) references group_room (id),
	constraint fk__group_group_room__group__id foreign key (group_id) references "group" (id)
);

create table group_schedule
(
	id 				int4 generated always as identity primary key,
	schedule_id		int4 not null,
	group_id		int4 not null,
	
	constraint fk__group_schedule__schedule__id foreign key (schedule_id) references schedule (id),
	constraint fk__group_schedule__group__id foreign key (group_id) references "group" (id)
);

create table lesson_teacher
(
	id 				int4 generated always as identity primary key,
	teacher_id		int4 not null,
	lesson_id		int4 not null,
	
	constraint fk__lesson_teacher__teacher__id foreign key (teacher_id) references teacher (id),
	constraint fk__lesson_teacher__lesson__id foreign key (lesson_id) references lesson (id)
);

create table lesson_group
(
	id 				int4 generated always as identity primary key,
	group_id		int4 not null,
	lesson_id		int4 not null,
	
	constraint fk__lesson_group__group__id foreign key (group_id) references "group" (id),
	constraint fk__lesson_group__lesson__id foreign key (lesson_id) references lesson (id)
);

create table lesson_subject
(
	id 				int4 generated always as identity primary key,
	subject_id		int4 not null,
	lesson_id		int4 not null,
	
	constraint fk__lesson_subject__subject__id foreign key (subject_id) references subject (id),
	constraint fk__lesson_subject__lesson__id foreign key (lesson_id) references lesson (id)
);

create table lesson_schedule
(
	id 				int4 generated always as identity primary key,
	schedule_id		int4 not null,
	lesson_id		int4 not null,
	
	constraint fk__lesson_schedule__schedule__id foreign key (schedule_id) references schedule (id),
	constraint fk__lesson_schedule__lesson__id foreign key (lesson_id) references lesson (id)
);

create table schedule_group_room
(
	id 				int4 generated always as identity primary key,
	group_room_id	int4 not null,
	schedule_id		int4 not null,
	
	constraint fk__schedule_group_room__group_room__id foreign key (group_room_id) references group_room (id),
	constraint fk__schedule_group_room__schedule__id foreign key (schedule_id) references schedule (id)
);

create table schedule_id
(
	id 				int4 generated always as identity primary key,
	teacher_id		int4 not null,
	school_id		int4 not null,
	
	constraint fk__school_teacher__teacher__id foreign key (teacher_id) references teacher (id),
	constraint fk__school_teacher__school__id foreign key (school_id) references school (id)
);

create table  school_student
(
	id 				int4 generated always as identity primary key,
	student_id		int4 not null,
	school_id		int4 not null,
	
	constraint fk__school_student__student__id foreign key (student_id) references student (id),
	constraint fk__school_student__school__id foreign key (school_id) references school (id)
);

create table student_lesson
(
	id 				int4 generated always as identity primary key,
	lesson_id		int4 not null,
	student_id		int4 not null,
	
	constraint fk__student_lesson__lesson__id	foreign key (lesson_id) references lesson (id),
	constraint fk__student_lesson__student__id foreign key (student_id) references student (id)
);

create table subject_teacher
(
	id 				int4 generated always as identity primary key,
	teacher_id		int4 not null,
	subject_id		int4 not null,
	
	constraint fk__subject_teacher__teacher__id foreign key (teacher_id) references teacher (id),
	constraint fk__subject_teacher__subject__id foreign key (subject_id) references subject (id)
);

create table teacher_assessment
(
	id 				int4 generated always as identity primary key,
	assessment_id	int8 not null,
	teacher_id		int4 not null,
	
	constraint fk__teacher_assessment__assessment__id foreign key (assessment_id) references assessment (id),
	constraint fk__teacher_assessment__teacher__id foreign key (teacher_id) references teacher (id)
);

