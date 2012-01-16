package am.ik.backbone.cellar.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import am.ik.backbone.cellar.entity.Wine;
import am.ik.backbone.cellar.repository.WineRepository;

@Controller
@RequestMapping("/rest/wines")
public class WineContoller {
    @Inject
    protected WineRepository wineRepository;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(WineContoller.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Wine> findAll() {
        List<Wine> wines = wineRepository.findAll();
        LOGGER.debug("findAll()={}", wines);
        return wines;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Wine findById(@PathVariable("id") Integer id) {
        Wine wine = wineRepository.findOne(id);
        LOGGER.debug("findOne({})={}", id, wine);
        return wine;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody
    Wine create(@RequestBody Wine wine) {
        LOGGER.debug("create({})", wine);
        wineRepository.saveAndFlush(wine);
        return wine;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    Wine update(@RequestBody Wine wine) {
        LOGGER.debug("update({})", wine);
        wineRepository.saveAndFlush(wine);
        return wine;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void delete(@PathVariable("id") Integer id) {
        LOGGER.debug("delete({})", id);
        wineRepository.delete(id);
        wineRepository.flush();
    }
}
