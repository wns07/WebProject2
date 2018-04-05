CREATE TABLE `book_ex`.`tbl_reply` (
  `rno` INT NOT NULL AUTO_INCREMENT,
  `bno` INT NOT NULL DEFAULT 0,
  `replytext` VARCHAR(1000) NOT NULL,
  `replyer` VARCHAR(50) NOT NULL,
  `regdate` TIMESTAMP NOT NULL DEFAULT now(),
  `updatedate` TIMESTAMP NOT NULL DEFAULT now(),
  PRIMARY KEY (`rno`));


alter table tbl_reply add constraint fk_board foreign key(bno) references tbl_board(bno);