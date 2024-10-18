-- 코드를 입력하세요
set @id := (SELECT BOARD_ID from USED_GOODS_BOARD
order by VIEWS desc
limit 1);


select concat('/home/grep/src/', @id, '/', FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH from USED_GOODS_FILE
where BOARD_ID = @id
order by FILE_PATH desc