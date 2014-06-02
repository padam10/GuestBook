/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Guestbook;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Padam
 */
@Stateless
public class GuestbookFacade extends AbstractFacade<Guestbook> {

    @PersistenceContext(unitName = "com.mycompany.pbhandaria2mnew_PBhandariA2Mnew_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuestbookFacade() {
        super(Guestbook.class);
    }

    public void persistGuestBookData(int id, String firstName, String lastName) {
        try {
            Guestbook g = new Guestbook();
            g.setId(id);
            g.setFirstname(firstName);
            g.setLastname(lastName);
            em.persist(g);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Guestbook> findByLastName(String name) {
// Query q = em.createNamedQuery("Guestbook.findByLastname");
        Query q = em.createQuery("SELECT g FROM Guestbook g WHERE g.lastname = :lastname");
        q.setParameter("lastname", name);
        List<Guestbook> guestList = q.getResultList();
        return guestList;
    }

    public List<Guestbook> showAllRecords() {
//create NamedQuery q using named query
        Query q = em.createQuery("SELECT g FROM Guestbook g");
        List<Guestbook> guestList = q.getResultList();
        return guestList;
    }

    public void editRecord(Guestbook entity) throws Exception {
        try {
            edit(entity);
        } catch (Exception e) {
            throw new Exception("Edit Transaction Failed");
        }
    }

    public List<Guestbook> findById(int id) {
        // implement method by//refer to the findByLastName method body
        Query q = em.createQuery("SELECT g FROM Guestbook g WHERE g.id = :id");
        q.setParameter("id", id);
        List<Guestbook> guestList = q.getResultList();
        return guestList;
    }

    public void deleteById(Guestbook entity) throws Exception {
        try {
            remove(entity);
        } catch (Exception e) {
            throw new Exception("Delete Transaction Failed");
        }
    }

    public int getNumberOfRecords() {// criteria query example
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Guestbook> rt = cq.from(Guestbook.class); //query root
        cq.select(cb.count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
