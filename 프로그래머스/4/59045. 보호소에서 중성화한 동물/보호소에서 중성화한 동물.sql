-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
FROM ANIMAL_INS i
JOIN ANIMAL_OUTS o ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE SUBSTRING_INDEX(SEX_UPON_INTAKE, " ", 1) = "Intact" and SUBSTRING_INDEX(SEX_UPON_OUTCOME, " ", 1) != "Intact"