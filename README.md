# 🛍️ Retail Mini – Coding Aufgabe

Dies ist eine kleine Beispielanwendung für einen **Online‑Shop**. Sie stellt Produkte bereit, ermöglicht das Hinzufügen von Artikeln in einen Warenkorb und die Auslösung einer Bestellung. Die Anwendung besteht aus einem **Backend (Java + Spring Boot)** mit REST‑API und einem **Frontend (React + TypeScript)**.

---

## 🚀 Ziel der Aufgabe

Erweitere die Anwendung um die Möglichkeit, **Promotion‑Codes (Gutscheincodes)** beim Checkout zu verwenden. Dabei sollen folgende Punkte abgedeckt sein:

- Ein Promotion-Code kann den Gesamtpreis eines Warenkorbs prozentual oder um einen festen Betrag reduzieren.
- Ein Code kann zeitlich begrenzt gültig sein (Start- und Enddatum).
- Es kann einen Mindestbestellwert geben, ab dem der Code angewendet werden darf.
- Konfliktfälle (z. B. ungültiger Code, abgelaufen) sollen klar erkennbar und sinnvoll behandelt werden.
- In der Oberfläche soll sichtbar sein, welcher Rabatt angewendet wurde und wie sich der Preis vor und nach Rabatt zusammensetzt.
- Nach dem Start der Anwendung sollen bereits einige verschiedene Promotion-Codes in der Datenbank vorhanden sein, die für Tests genutzt werden können.

Zusätzlich sollen die **folgenden zwei Bugs** im bestehenden Code identifiziert und behoben werden.

1. Versucht man, einen Artikel in den Warenkorb zu legen, so wird dieser doppelt hinzugefügt, statt die Menge zu erhöhen.
2. Löscht man einen Artikel aus dem Warenkorb, so verschwindet er erst nach einem Reload der Seite.

---

## ⚙️ Quick Start

Um die Anwendung zu starten, führe die beigefügten Run-Configs in IntelliJ aus oder befolge die folgenden Schritte:

1. Datenbank starten \
`cd stack && docker compose up`
2. Backend starten \
`cd services/shop-backend && ./gradlew bootRun`
3. Frontend starten \
`cd services/shop-frontend && npm install && npm run dev`

Anschließend ist die Anwendung unter **[http://localhost:5173](http://localhost:5173)** erreichbar.

---

## 📋 Abgabe

Bitte forke dieses Repository und implementiere die Aufgabe in deinem Fork. 
Stelle dein Repository auf `private` und erlaube uns den Zugriff auf deinen Fork.
Zur Abgabe beachte bitte Folgendes:

* Bitte schicke uns den GitHub‑Link zu deinem Fork spätestens zwei Tage vor dem Gespräch zu.
* Passe die **README.md** in deinem Fork an und dokumentiere dort:
    * Umsetzung der Promotion‑Funktion
    * kurze Architektur‑Notizen
    * ggf. offene Punkte

---

## 🎤 Demo

Im dritten Gespräch sprechen wir gemeinsam über deine Lösung:

* Du stellst uns in einer kurzen Demo deine Lösung vor
* Du erklärst uns deine Architekturentscheidungen und zeigst uns die Umsetzung im Code
* Wir diskutieren über deine Lösung, mögliche Alternativen und Verbesserungen

* Viel Erfolg bei der Aufgabe! 🚀
