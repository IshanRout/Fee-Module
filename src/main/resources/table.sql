CREATE TABLE campus
(
    campus_id   INT          NOT NULL,
    campus_name VARCHAR(25)  NOT NULL       UNIQUE,
    CONSTRAINT pk_campus PRIMARY KEY (campus_id)
);

CREATE TABLE programme
(
    programme_id   INT          NOT NULL,
    programme_name VARCHAR(25)  NOT NULL       UNIQUE,
    CONSTRAINT pk_programme PRIMARY KEY (programme_id)
);

CREATE TABLE branch
(
    branch_id     INT          NOT NULL,
    branch_name   VARCHAR(25)  NOT NULL       UNIQUE,
    programme_id  INT          NOT NULL,
    CONSTRAINT pk_branch PRIMARY KEY (branch_id),
    CONSTRAINT FK_BRANCH_ON_ID FOREIGN KEY (programme_id) REFERENCES programme (programme_id)
);
CREATE TABLE user
(
    user_id       INT          NOT NULL,
    user_name     VARCHAR(255) NOT NULL,
    phone_number  BIGINT       NOT NULL,
    email_id      VARCHAR(255) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    `role`        INT          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE student_detail
(
    student_id            INT          NOT NULL,
    user_id               INT          NOT NULL,
    registration_number   VARCHAR(10)  NOT NULL       UNIQUE,
    batch_year            INT          NOT NULL,
    programme_id          INT          NOT NULL,
    CONSTRAINT pk_student_detail PRIMARY KEY (student_id),
    CONSTRAINT FK_STUDENT_DETAIL_ON_PROGRAM_ID FOREIGN KEY (programme_id) REFERENCES programme (programme_id),
    CONSTRAINT FK_STUDENT_DETAIL_ON_USERID FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE employee
(
    employee_id     INT          NOT NULL,
    user_id         INT          NOT NULL,
    year_of_joining INT          NOT NULL,
    designation     VARCHAR(25)  NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (employee_id),
    CONSTRAINT FK_EMPLOYEE_ON_USERID FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE hostel_master
(
    hostel_id   INT          NOT NULL,
    hostel_name VARCHAR(20)  NOT NULL       UNIQUE,
    campus_id   INT          NOT NULL,
    CONSTRAINT pk_hostel_master PRIMARY KEY (hostel_id),
    CONSTRAINT FK_CAMPUS FOREIGN KEY (campus_id) REFERENCES campus (campus_id)
);


CREATE TABLE hostel_fee_master
(
    hostel_fee_master_id   INT      NOT NULL,
    room_category          INT      NOT NULL,
    fee_for_year           INT      NOT NULL,
    academic_year          INT      NOT NULL,
    due_date               DATE     NOT NULL,
    campus_id              INT      NOT NULL,
    programme_id           INT      NULL,
    CONSTRAINT pk_hostel_fee_master PRIMARY KEY (hostel_fee_master_id),
    CONSTRAINT FK_HOSTEL_FEE_MASTER_ON_PROGRAMME_ID FOREIGN KEY (programme_id) REFERENCES programme (programme_id),
    CONSTRAINT FK_HOSTEL_FEE_MASTER_ON_CAMPUS_ID FOREIGN KEY (campus_id) REFERENCES campus (campus_id)
);

CREATE TABLE hostel_stay
(
    hostel_stay_id  INT      NOT NULL,
    student_id      INT      NOT NULL,
    hostel_id       INT      NOT NULL,
    room_category   INT      NOT NULL,
    date_of_joining DATE     NOT NULL,
    date_of_leave   DATE     NULL,
    CONSTRAINT pk_hostel_stay PRIMARY KEY (hostel_stay_id),
    CONSTRAINT FK_HOSTEL_STAY_ON_HOSTEL_ID FOREIGN KEY (hostel_id) REFERENCES hostel_master (hostel_id),
    CONSTRAINT FK_HOSTEL_STAY_ON_STUDENT_ID FOREIGN KEY (student_id) REFERENCES student_detail (student_id)
);

CREATE TABLE academic_fee
(
    academic_fee_id     INT      NOT NULL,
    year                INT      NOT NULL,
    due_date            DATE     NOT NULL,
    programme_id        INT      NOT NULL,
    fee_for_campus_id   INT      NOT NULL,
    branch_branch_id    INT      NOT NULL,
    fees_per_semester   DOUBLE   NOT NULL,
    CONSTRAINT pk_academic_fee_per_programme PRIMARY KEY (academic_fee_id),
    CONSTRAINT FK_ACADEMIC_FEE_PER_PROGRAMME_ON_BRANCH_BRANCH_ID FOREIGN KEY (branch_branch_id) REFERENCES branch (branch_id),
    CONSTRAINT FK_ACADEMIC_FEE_PER_PROGRAMME_ON_FEE_FOR_CAMPUS FOREIGN KEY (fee_for_campus_id) REFERENCES campus (campus_id),
    CONSTRAINT FK_ACADEMIC_FEE_PER_PROGRAMME_ON_PROGRAMME_ID FOREIGN KEY (programme_id) REFERENCES programme (programme_id)
);

CREATE TABLE route_set
(
    route_set_id                 INT          NOT NULL,
    route_set_name               VARCHAR(35)  NOT NULL       UNIQUE,
    campus_id_for_route          INT          NOT NULL,
    CONSTRAINT pk_route_set PRIMARY KEY (route_set_id),
    CONSTRAINT FK_ROUTE_SET_ON_CAMPUS_ID FOREIGN KEY (campus_id_for_route) REFERENCES campus (campus_id)
);

CREATE TABLE transportation_master
(
    transportation_id INT          NOT NULL,
    route_name        VARCHAR(25)  NOT NULL,
    vehicle_number    INT          NOT NULL       UNIQUE,
    route_set_id      INT          NOT NULL,
    CONSTRAINT pk_transportation_master PRIMARY KEY (transportation_id),
    CONSTRAINT FK_TRANSPORTATION_MASTER_ON_ROUTE_ID FOREIGN KEY (route_set_id) REFERENCES route_set (route_set_id)
);

CREATE TABLE transportation_fee_master
(
    transportation_fee_master_id INT      NOT NULL,
    fee_per_year                 DOUBLE   NOT NULL,
    academic_year                INT      NOT NULL,
    due_date                     DATE     NOT NULL,
    route_set_id                 INT      NOT NULL,
    CONSTRAINT pk_transportation_fee_master PRIMARY KEY (transportation_fee_master_id),
    CONSTRAINT FK_TRANSPORTATION_FEE_MASTER_ON_ROUTE_ID FOREIGN KEY (route_set_id) REFERENCES route_set (route_set_id)
);

CREATE TABLE transport_pickup_location
(
    transport_pickup_id    INT         NOT NULL,
    location               VARCHAR(50) NOT NULL       UNIQUE,
    transportation_id      INT         NOT NULL,
    CONSTRAINT pk_transport_pickup_location PRIMARY KEY (transport_pickup_id),
    CONSTRAINT FK_TRANSPORT_PICKUP_LOCATION_ON_TRANSPORT_ID FOREIGN KEY (transportation_id) REFERENCES transportation_master (transportation_id)
);

CREATE TABLE student_transportation
(
    student_transportation_id INT      NOT NULL,
    student_id                INT      NOT NULL,
    date_of_issue             datetime NOT NULL,
    validation_date           datetime NOT NULL,
    transportation_id         INT      NOT NULL,
    transport_pickup_id       INT      NOT NULL,
    CONSTRAINT pk_student_transportation PRIMARY KEY (student_transportation_id),
    CONSTRAINT FK_STUDENT_TRANSPORTATION_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student_detail (student_id),
    CONSTRAINT FK_STUDENT_TRANSPORTATION_ON_TRANSPORTATION FOREIGN KEY (transportation_id) REFERENCES transportation_master (transportation_id),
    CONSTRAINT FK_STUDENT_TRANSPORTATION_ON_TRANSPORT_PICKUP FOREIGN KEY (transport_pickup_id) REFERENCES transport_pickup_location (transport_pickup_id)

);

CREATE TABLE miscellaneous_head
(
    miscellaneous_head_id INT          NOT NULL,
    head_name             VARCHAR(255) NOT NULL,
    one_time_payment      BIT(1)       NOT NULL,
    CONSTRAINT pk_miscellaneous_head PRIMARY KEY (miscellaneous_head_id)
);

CREATE TABLE miscellaneous_fee_master
(
    miscellaneous_fee_id      INT    NOT NULL,
    miscellaneous_fee_head_id INT    NOT NULL,
    academic_year             INT    NOT NULL,
    semester                  INT    NOT NULL,
    amount                    DOUBLE NOT NULL,
    campus_id                 INT    NOT NULL,
    programme_id              INT    NULL,
    branch_id                 INT    NULL,
    CONSTRAINT pk_miscellaneous_fee_master PRIMARY KEY (miscellaneous_fee_id),
    CONSTRAINT FK_MISCELLANEOUS_FEE_MASTER_ON_BRANCH FOREIGN KEY (branch_id) REFERENCES branch (branch_id),
    CONSTRAINT FK_MISCELLANEOUS_FEE_MASTER_ON_CAMPUS FOREIGN KEY (campus_id) REFERENCES campus (campus_id),
    CONSTRAINT FK_MISCELLANEOUS_FEE_MASTER_ON_MISCELLANEOUS_FEE_HEAD FOREIGN KEY (miscellaneous_fee_head_id) REFERENCES miscellaneous_head (miscellaneous_head_id),
    CONSTRAINT FK_MISCELLANEOUS_FEE_MASTER_ON_PROGRAMME FOREIGN KEY (programme_id) REFERENCES programme (programme_id)



);

CREATE TABLE fee_payment_info
(
    fee_payment_id   INT          NOT NULL,
    transaction_id   INT          NOT NULL       UNIQUE,
    year             VARCHAR(255) NOT NULL,
    fee_head         INT          NOT NULL,
    time_of_payment  DATE         NOT NULL,
    amount           DOUBLE       NOT NULL,
    transaction_type VARCHAR(255) NOT NULL,
    entered_by       VARCHAR(255) NOT NULL,
    CONSTRAINT pk_fee_payment_info PRIMARY KEY (fee_payment_id)
);

CREATE TABLE concession
(
    concession_id   INT          NOT NULL,
    student_id      INT          NOT NULL,
    concession_type VARCHAR(255) NOT NULL,
    semester        INT          NOT NULL,
    year            INT          NOT NULL,
    amount          DOUBLE       NOT NULL,
    generation_date date         NOT NULL,
    availed_date    date         NOT NULL,
    CONSTRAINT pk_concession PRIMARY KEY (concession_id),
    CONSTRAINT FK_CONCESSION_ON_STUDENT_ID FOREIGN KEY (student_id) REFERENCES student_detail (student_id)
);


CREATE TABLE fine
(
    fine_id         INT          NOT NULL,
    student_id      INT          NOT NULL,
    fine_type       VARCHAR(25)  NOT NULL,
    semester        INT          NOT NULL,
    academic_year   INT          NOT NULL,
    amount          DOUBLE       NOT NULL,
    generation_date date         NOT NULL,
    due_date        date         NULL,
    paid_date       date         NULL,
    status          VARCHAR(25) NOT NULL,
    CONSTRAINT pk_fine PRIMARY KEY (fine_id),
    CONSTRAINT FK_FINE_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student_detail (student_id)
);

CREATE TABLE refund
(
    refund_id       INT          NOT NULL,
    student_id      INT          NOT NULL,
    refund_type     VARCHAR(25)  NOT NULL,
    semester        INT          NOT NULL,
    academic_year   INT          NOT NULL,
    amount          DOUBLE       NOT NULL,
    status          VARCHAR(255) NOT NULL,
    initiation_date date         NOT NULL,
    collection_date date         NULL,
    CONSTRAINT pk_refund PRIMARY KEY (refund_id),
    CONSTRAINT FK_REFUND_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student_detail (student_id)
);
CREATE TABLE student_transportation
(
    student_transportation_id INT      NOT NULL,
    student_id                INT      NULL,
    date_of_issue             datetime NULL,
    validation_date           datetime NULL,
    transport_pickup_id       INT      NULL,
    CONSTRAINT pk_student_transportation PRIMARY KEY (student_transportation_id)
);

ALTER TABLE student_transportation
    ADD CONSTRAINT FK_STUDENT_TRANSPORTATION_ON_STUDENT FOREIGN KEY (student_id) REFERENCES student_detail (student_id);

ALTER TABLE student_transportation
    ADD CONSTRAINT FK_STUDENT_TRANSPORTATION_ON_TRANSPORT_PICKUP FOREIGN KEY (transport_pickup_id) REFERENCES transport_pickup_location (transport_pickup_id);