package ru.otus;

import java.util.Map;

public interface IATM {
    void giveCash(Map<CashType, Long> incomeCash);
    Map<CashType, Long> takeCash(Long sum);
    Long allCash();
}
