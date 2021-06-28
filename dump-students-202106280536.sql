--
-- PostgreSQL database dump
--

-- Dumped from database version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)

-- Started on 2021-06-28 05:36:55 CST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 7 (class 2615 OID 16446)
-- Name: enrolla; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA enrolla;


ALTER SCHEMA enrolla OWNER TO postgres;

--
-- TOC entry 209 (class 1255 OID 16577)
-- Name: student_func(); Type: FUNCTION; Schema: enrolla; Owner: postgres
--

CREATE FUNCTION enrolla.student_func() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin 
	insert  into  "user" (id, email ,"password", username) values (new.ID, new.email, new.password,new.email);
	return new;
end;
$$;


ALTER FUNCTION enrolla.student_func() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 17335)
-- Name: courses; Type: TABLE; Schema: enrolla; Owner: postgres
--

CREATE TABLE enrolla.courses (
    id integer NOT NULL,
    category character varying(50),
    course_name character varying(40),
    created character varying(40),
    description character varying(200),
    duration character varying(40),
    start_date timestamp without time zone
);


ALTER TABLE enrolla.courses OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17342)
-- Name: enrollment; Type: TABLE; Schema: enrolla; Owner: postgres
--

CREATE TABLE enrolla.enrollment (
    id integer NOT NULL,
    address character varying(40),
    course_id integer,
    date_of_enrollment timestamp without time zone,
    dateofbirth timestamp without time zone,
    education character varying(40),
    gender character varying(40),
    language character varying(40),
    phone character varying(40),
    plan integer,
    student_id integer
);


ALTER TABLE enrolla.enrollment OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 17340)
-- Name: enrollment_id_seq; Type: SEQUENCE; Schema: enrolla; Owner: postgres
--

ALTER TABLE enrolla.enrollment ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME enrolla.enrollment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 207 (class 1259 OID 17349)
-- Name: user; Type: TABLE; Schema: enrolla; Owner: postgres
--

CREATE TABLE enrolla."user" (
    id integer NOT NULL,
    country character varying(255),
    email character varying(255) NOT NULL,
    fullname character varying(255),
    password character varying(255),
    username character varying(255) NOT NULL
);


ALTER TABLE enrolla."user" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17347)
-- Name: user_id_seq; Type: SEQUENCE; Schema: enrolla; Owner: postgres
--

ALTER TABLE enrolla."user" ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME enrolla.user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 208 (class 1259 OID 17361)
-- Name: user_roles; Type: TABLE; Schema: enrolla; Owner: postgres
--

CREATE TABLE enrolla.user_roles (
    user_id integer NOT NULL,
    roles integer
);


ALTER TABLE enrolla.user_roles OWNER TO postgres;

--
-- TOC entry 2988 (class 0 OID 17335)
-- Dependencies: 203
-- Data for Name: courses; Type: TABLE DATA; Schema: enrolla; Owner: postgres
--

COPY enrolla.courses (id, category, course_name, created, description, duration, start_date) FROM stdin;
1	Java	Java Advanced	\N	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 	12000	\N
2	Javascript	Javascript Basics	\N	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 	12000	\N
3	Python	Python Statisticss	\N	Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore 	12000	\N
4	UI/UX	UI/UX Design	\N	Lorem ipsum dolor sit amet, consec	12000	\N
5	Spring Boot	Spring Boot	\N	Lorem ipsum dolor sit amet, consec	12000	\N
6	Vue	Vue.js Advanced	\N	Lorem ipsum dolor sit amet, consec	12000	\N
\.


--
-- TOC entry 2990 (class 0 OID 17342)
-- Dependencies: 205
-- Data for Name: enrollment; Type: TABLE DATA; Schema: enrolla; Owner: postgres
--

COPY enrolla.enrollment (id, address, course_id, date_of_enrollment, dateofbirth, education, gender, language, phone, plan, student_id) FROM stdin;
19	nuevo	1	\N	\N	nuevo	falso	spanish	45555	4	1
20	\N	2	\N	1960-01-01 00:00:00	Masters Degree	Fert	Fa	543545454354	\N	1
\.


--
-- TOC entry 2992 (class 0 OID 17349)
-- Dependencies: 207
-- Data for Name: user; Type: TABLE DATA; Schema: enrolla; Owner: postgres
--

COPY enrolla."user" (id, country, email, fullname, password, username) FROM stdin;
1	\N	admin@email.com	\N	$2a$12$aE5etfaPwsJ/ytle9rvcZOkqroKFtF5r6C3j/puqL8.inpR7p/X0y	admin
2	\N	client@email.com	\N	$2a$12$fQyrwLkjuY8uUQX3LevcUO//Te6ai9EaNwJXMLp/eMex6BwLnFRFW	client
4	\N	fer@mail.com	Fernando	$2a$12$1jABX5SRXi/9U8/MbdUOduqTZgyvxMPwSyqvzmTzuh0X2GQcKNP2C	fer@mail.com
5	\N			$2a$12$u4yGoIHmDspHudlFmjrLAeVm.to6DMjjC7kXH/bm..CA.9KEtDgVC	
\.


--
-- TOC entry 2993 (class 0 OID 17361)
-- Dependencies: 208
-- Data for Name: user_roles; Type: TABLE DATA; Schema: enrolla; Owner: postgres
--

COPY enrolla.user_roles (user_id, roles) FROM stdin;
1	0
2	1
4	0
5	0
\.


--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 204
-- Name: enrollment_id_seq; Type: SEQUENCE SET; Schema: enrolla; Owner: postgres
--

SELECT pg_catalog.setval('enrolla.enrollment_id_seq', 20, true);


--
-- TOC entry 3000 (class 0 OID 0)
-- Dependencies: 206
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: enrolla; Owner: postgres
--

SELECT pg_catalog.setval('enrolla.user_id_seq', 5, true);


--
-- TOC entry 2850 (class 2606 OID 17339)
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);


--
-- TOC entry 2852 (class 2606 OID 17346)
-- Name: enrollment enrollment_pkey; Type: CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla.enrollment
    ADD CONSTRAINT enrollment_pkey PRIMARY KEY (id);


--
-- TOC entry 2854 (class 2606 OID 17358)
-- Name: user uk_ob8kqyqqgmefl0aco34akdtpe; Type: CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla."user"
    ADD CONSTRAINT uk_ob8kqyqqgmefl0aco34akdtpe UNIQUE (email);


--
-- TOC entry 2856 (class 2606 OID 17360)
-- Name: user uk_sb8bbouer5wak8vyiiy4pf2bx; Type: CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla."user"
    ADD CONSTRAINT uk_sb8bbouer5wak8vyiiy4pf2bx UNIQUE (username);


--
-- TOC entry 2858 (class 2606 OID 17356)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2861 (class 2606 OID 17374)
-- Name: user_roles fk55itppkw3i07do3h7qoclqd4k; Type: FK CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla.user_roles
    ADD CONSTRAINT fk55itppkw3i07do3h7qoclqd4k FOREIGN KEY (user_id) REFERENCES enrolla."user"(id);


--
-- TOC entry 2860 (class 2606 OID 17369)
-- Name: enrollment fk65os88xfjxr2tos3tksqeleg6; Type: FK CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla.enrollment
    ADD CONSTRAINT fk65os88xfjxr2tos3tksqeleg6 FOREIGN KEY (student_id) REFERENCES enrolla."user"(id);


--
-- TOC entry 2859 (class 2606 OID 17364)
-- Name: enrollment fk7ofybdo2o0ngc4de3uvx4dxqv; Type: FK CONSTRAINT; Schema: enrolla; Owner: postgres
--

ALTER TABLE ONLY enrolla.enrollment
    ADD CONSTRAINT fk7ofybdo2o0ngc4de3uvx4dxqv FOREIGN KEY (course_id) REFERENCES enrolla.courses(id);


-- Completed on 2021-06-28 05:36:55 CST

--
-- PostgreSQL database dump complete
--
