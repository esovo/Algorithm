-- 코드를 입력하세요

SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(*) as RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= "2022-08-01" and START_DATE <= "2022-10-31" 
    and CAR_ID in (   
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE >= "2022-08-01" and START_DATE <= "2022-10-31"
        GROUP BY CAR_ID
        HAVING COUNT(CAR_ID) >= 5
    )
GROUP BY MONTH, CAR_ID
ORDER BY MONTH, CAR_ID desc