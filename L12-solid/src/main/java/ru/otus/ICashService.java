package ru.otus;

import java.util.Map;

public interface ICashService {
    void putCash(Map<CashType, Long> cash);
    Map<CashType, Long> getCash(Long sum);

}
