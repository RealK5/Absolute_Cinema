# Absolute_Cinema
## Pomysł 2: Kino — rezerwacja i sprzedaż biletów

Cel: zarządzanie salami, seansami, miejscami i rezerwacjami biletów, z różnymi typami sal lub projekcji.

### Lista kontrolna
1. Struktura i pakiety [02][04]
   - `cinema.domain`, `cinema.service`, `cinema.app`, `cinema.util`. [04]
   - `cinema.app.Main` z `main`. [03]
2. Abstrakcja sali/projekcji [08]
   - `abstract class Auditorium` (nazwa, liczba rzędów, układ). [08][05b]
   - Implementacje: `StandardAuditorium`, `IMAXAuditorium` (np. inna siatka miejsc). [07]
3. Seanse i miejsca [05b][06]
   - `domain.Show` (film, sala, czas startu). [05b]
   - `domain.Seat` (rząd, miejsce, status). Walidacje w konstruktorach. [06]
4. Interfejsy [08]
   - `domain.Bookable` (`book()`, `cancel()`, `isAvailable()`) dla miejsca/seansu. [08]
   - `domain.Exportable` (`toCsv()` dla raportu sprzedaży). [08]
5. Serwisy [03]
   - `service.SeatMapService` generuje mapę miejsc dla sali. [03]
   - `service.TicketService` zarządza rezerwacjami i sprzedażą. [03]
6. Dostęp i kapsułkowanie [05]
   - Prywatne pola, kontrolowany mutowalny stan miejsc. [05]
7. Polimorfizm [07]
   - Różne sale wpływają na sposób tworzenia map miejsc i cenę (opcjonalnie). [07]
8. Demo [03]
   - Zdefiniuj 2 sale, 2 seanse, zrób rezerwacje i eksport raportu CSV. [03]
9. Rozszerzenia (opcjonalnie) [07][08]
   - `PricingStrategy` (dzień tygodnia, strefy miejsc). [08]
   - `abstract Ticket` z podklasami `StandardTicket`, `PremiumTicket`. [07]
10. GitHub [02]
    - Repo, `.gitignore`, `README.md` z mapą miejsc (ASCII). [02]
