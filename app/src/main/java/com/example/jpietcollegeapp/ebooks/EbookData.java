package com.example.jpietcollegeapp.ebooks;

public class EbookData {
    private String pdfTite, pdfUrl;

    public EbookData() {
    }

    public EbookData(String pdfTite, String pdfUrl) {
        this.pdfTite = pdfTite;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTite() {
        return pdfTite;
    }

    public void setPdfTite(String pdfTite) {
        this.pdfTite = pdfTite;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}