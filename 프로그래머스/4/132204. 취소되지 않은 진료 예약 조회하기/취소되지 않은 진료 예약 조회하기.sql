SELECT a.APNT_NO,	p.PT_NAME,	p.PT_NO,	a.MCDP_CD,	d.DR_NAME,	a.APNT_YMD
from APPOINTMENT as a
join PATIENT as p on a.PT_NO = p.PT_NO
join DOCTOR as d on a.MDDR_ID = d.DR_ID

where year(a.APNT_YMD) = 2022
and month(a.APNT_YMD) = 4
and day(a.APNT_YMD) = 13
and a.MCDP_CD = 'CS'
and a.APNT_CNCL_YN = 'N'

order by APNT_YMD