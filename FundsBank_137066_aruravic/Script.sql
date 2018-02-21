CREATE TABLE complaint(complaintid number primary key,accountid number,branchcode varchar2(20),emailid varchar2(20),category varchar2(20),description varchar2(300),priority varchar2(10),status varchar2(20));
CREATE SEQUENCE hibernate_sequence;
INSERT INTO complaint VALUES(3145,6873842,’FCFC12’,’tina@igate.com’,’Internet Banking’,’Net banking account is locked’,’High’,’Closed’);
INSERT INTO complaint VALUES(3146,6873845,’FCFC12’,’paiva@igate.com’,’Internet Banking’,’Net banking account is locked’,’High’,’Work is in progress’);
Commit;
